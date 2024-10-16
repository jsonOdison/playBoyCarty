package com.cartOfLife.playBoyCarty.services.products;

import java.util.List;

import com.cartOfLife.playBoyCarty.exception.ProductNotFoundException;
import com.cartOfLife.playBoyCarty.model.Product;
import com.cartOfLife.playBoyCarty.repository.productRepository.ProductRepository;

public class ProductService implements iProductService {

    private ProductRepository productRepo;

    @Override

    public Product addProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public List<Product> getAProducts() {
        return productRepo.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepo.findById(id).orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + id));
    }

    @Override
    public void updateProductById(Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void deleteProductById(Long id, Product product) {
        productRepo.findById(id).ifPresentOrElse((productRepo::delete), () -> new ProductNotFoundException("Product not found with id: " + id));
    }

    @Override
    public List<Product> getProductByCategory(String brand, String category) {
        return productRepo.findByCategoryName(category);
    }

    @Override
    public List<Product> getProductByBrand(String brand) {
        return productRepo.findByBrandName(brand);
    }

    @Override
    public List<Product> getProductByCategoryAndBrand(String categoroy, String brand) {
        return productRepo.findByProductByCategoryAndBrand(categoroy, brand);
    }

    @Override
    public List<Product> getProductByName(String name) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Product> getProductByBrandAndName(String categoroy, String brand) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Long countProductsByBranndAndName(String brand, String name) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
