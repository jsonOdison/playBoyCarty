package com.cartOfLife.playBoyCarty.services.image;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.cartOfLife.playBoyCarty.model.DTO.AddImage;
import com.cartOfLife.playBoyCarty.model.Image;

public interface IImageService {

    Image getImageByID(Long id);

    void deleteImageByID(Long id);

    List<AddImage> saveImage(List<MultipartFile> files, Long productID);

    void updateImage(MultipartFile file, Long imageId);
}
