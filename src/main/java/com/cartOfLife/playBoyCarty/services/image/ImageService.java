package com.cartOfLife.playBoyCarty.services.image;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cartOfLife.playBoyCarty.exception.ResourceNotFoundException;
import com.cartOfLife.playBoyCarty.model.DTO.AddImage;
import com.cartOfLife.playBoyCarty.model.Image;
import com.cartOfLife.playBoyCarty.model.Product;
import com.cartOfLife.playBoyCarty.repository.imageRepository.ImageRepository;
import com.cartOfLife.playBoyCarty.services.products.ProductService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class ImageService implements IImageService {

    private ImageRepository imageRepository;
    private ProductService productService;

    @Override
    public Image getImageByID(Long id) {

        return imageRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Image not found with ID:" + id));
    }

    @Override
    public void deleteImageByID(Long id) {
        imageRepository.findById(id).ifPresentOrElse(imageRepository::delete, () -> {
            throw new ResourceNotFoundException("Image not found with ID:" + id);
        });
    }

    @Override
    public List<AddImage> saveImage(List<MultipartFile> files, Long productID) {
        Product product = productService.getProductById(productID);
        List<AddImage> imageDtoList = new ArrayList<>();
        String downloadUrlString = "/api/v1/images/image/download";

        for (MultipartFile file : files) {
            try {
                Image image = buildImageEntity(file, product);
                imageRepository.save(image);

                Image savedImage = updateImageWithDownloadUrl(image, downloadUrlString);
                imageRepository.save(savedImage);

                AddImage imageDto = createImageDto(savedImage);
                imageDtoList.add(imageDto);

            } catch (IOException | SQLException e) {
                throw new RuntimeException(e.getMessage());
            }
        }
        return imageDtoList;
    }

    private Image buildImageEntity(MultipartFile file, Product product) throws IOException, SQLException {
        Image image = new Image();
        image.setFileName(file.getOriginalFilename());
        image.setFileType(file.getContentType());
        image.setImage(new SerialBlob(file.getBytes()));
        // image.setProduct(product);
        return image;
    }

    private Image updateImageWithDownloadUrl(Image image, String downloadUrlString) {
        String downloadUrl = downloadUrlString + image.getId();
        image.setDownloadUrl(downloadUrl);
        return image;
    }

    private AddImage createImageDto(Image savedImage) {
        AddImage imageDto = new AddImage();
        imageDto.setImageId(savedImage.getId());
        imageDto.setImageName(savedImage.getFileName());
        imageDto.setDownloadUrl(savedImage.getDownloadUrl());
        return imageDto;
    }

    @Override
    public void updateImage(MultipartFile file, Long imageId
    ) {
        Image image = getImageByID(imageId);
        try {
            image.setFileName(file.getOriginalFilename());
            image.setImage(new SerialBlob(file.getBytes()));
            imageRepository.save(image);
        } catch (IOException | SQLException e) {
            throw new RuntimeException(e.getMessage());

        }

    }
}
