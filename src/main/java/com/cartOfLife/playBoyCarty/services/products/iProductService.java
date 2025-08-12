package com.cartOfLife.playBoyCarty.services.products;

import java.util.List;

import com.cartOfLife.playBoyCarty.model.Product;

public interface iProductService {

    // Product addProduct(AddProductModel product);
    List<Product> getAProducts();

    Product getProductById(Long id);

    // Product updateProductById(UpdateProductModel updateProduct, Long id);
    void deleteProductById(Long id, Product product);

    // List<Product> getProductByCategory(String brand, String category);
    // List<Product> getProductByBrand(String brand);
    // List<Product> getProductByCategoryAndBrand(String categoroy, String brand);
    // List<Product> getProductByName(String name);
    // List<Product> getProductByBrandAndName(String categoroy, String brand);
    Long countProductsByBranndAndName(String brand, String name);
}
