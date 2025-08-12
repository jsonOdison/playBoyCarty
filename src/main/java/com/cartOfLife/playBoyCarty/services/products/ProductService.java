package com.cartOfLife.playBoyCarty.services.products;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cartOfLife.playBoyCarty.exception.ProductNotFoundException;
import com.cartOfLife.playBoyCarty.model.Product;
import com.cartOfLife.playBoyCarty.repository.productRepository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService implements iProductService {

    private final ProductRepository productRepo;
    // private final CategoryRepository categoryRepository;

    @Override
    public List<Product> getAProducts() {
        return productRepo.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepo.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + id));
    }

    // @Override
    // public Product updateProductById(UpdateProductModel updateProduct, Long id) {
    //     return productRepo.findById(id)
    //             .map(product -> {
    //                 updateExistingProduct(product, updateProduct);
    //                 return productRepo.save(product); // Save and return updated product
    //             })
    //             .orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + id));
    // }
    // private void updateExistingProduct(Product existingProd, UpdateProductModel updateRequest) {
    //     existingProd.setName(updateRequest.getName());
    //     existingProd.setBrand(updateRequest.getBrand());
    //     existingProd.setPrice(updateRequest.getPrice());
    //     existingProd.setInventory(updateRequest.getInventory());
    //     existingProd.setDescription(updateRequest.getDescription());
    //     Category category = categoryRepository.findByName(updateRequest.getCategory().getName());
    //     if (category == null) {
    //         throw new ProductNotFoundException("Category not found: " + updateRequest.getCategory().getName());
    //     }
    //     // existingProd.setCategory(category);
    // }
    @Override
    public void deleteProductById(Long id, Product product) {
        productRepo.findById(id)
                .ifPresentOrElse(productRepo::delete,
                        () -> {
                            throw new ProductNotFoundException("Product not found with id: " + id);
                        });
    }

    @Override
    public Long countProductsByBranndAndName(String brand, String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'countProductsByBranndAndName'");
    }

    // @Override
    // public List<Product> getProductByCategory(String brand, String category) {
    //     return productRepo.findByCategoryName(category);
    // }
    //  
    // @Override
    // public List<Product> getProductByCategoryAndBrand(String category, String brand) {
    //     return productRepo.findByProductByCategoryAndBrand(category, brand);
    // }
    // @Override
    // public List<Product> getProductByName(String name) {
    //     return productRepo.findProductByName(name);
    // }
    // @Override
    // public List<Product> getProductByBrandAndName(String brand, String name) {
    //     return productRepo.getProductByBrandAndName(brand, name);
    // }
    // @Override
    // public Long countProductsByBranndAndName(String brand, String name) {
    //     return productRepo.countProductByBrandAndName(brand, name);
    // }
}
