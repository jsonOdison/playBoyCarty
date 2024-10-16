package com.cartOfLife.playBoyCarty.services.products;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cartOfLife.playBoyCarty.exception.ProductNotFoundException;
import com.cartOfLife.playBoyCarty.model.Category;
import com.cartOfLife.playBoyCarty.model.Product;
import com.cartOfLife.playBoyCarty.model.ProductModel.AddProductModel;
import com.cartOfLife.playBoyCarty.repository.productRepository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {

    @Autowired
    private ProductRepository productRepo;

    @Override

    public Product addProduct(AddProductModel product) {

        return productRepo.addProduct(product);
    }

    private Product createProduct(AddProductModel request, Category category) {
        return new Product(
                request.getBrand(),
                category,
                request.getDescription(),
                request.getInventory(),
                request.getName(),
                request.getPrice()
        );
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
    public List<Product> getProductByCategoryAndBrand(String category, String brand) {
        return productRepo.findByProductByCategoryAndBrand(category, brand);
    }

    @Override
    public List<Product> getProductByName(String name) {
        return productRepo.findProductByName(name);
    }

    @Override
    public List<Product> getProductByBrandAndName(String category, String brand) {
        return productRepo.getProductByBrandAndName(category, brand);
    }

    @Override
    public Long countProductsByBranndAndName(String brand, String name) {
        return productRepo.countProductByBrandAndName(brand, name);
    }

}
