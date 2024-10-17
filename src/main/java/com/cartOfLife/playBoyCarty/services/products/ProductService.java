package com.cartOfLife.playBoyCarty.services.products;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cartOfLife.playBoyCarty.exception.ProductNotFoundException;
import com.cartOfLife.playBoyCarty.model.Category;
import com.cartOfLife.playBoyCarty.model.DTO.AddProductModel;
import com.cartOfLife.playBoyCarty.model.DTO.UpdateProductModel;
import com.cartOfLife.playBoyCarty.model.Product;
import com.cartOfLife.playBoyCarty.repository.categoryRepository.CategoryRepository;
import com.cartOfLife.playBoyCarty.repository.productRepository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {

    @Autowired
    private ProductRepository productRepo;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override

    public Product addProduct(AddProductModel requestProduct) {
        // Get the category, creating it if not found
        Category category = findOrCreateCategory(requestProduct.getCategory().getName());

        // Create the product with the retrieved/created category and save it
        Product product = createProduct(requestProduct, category);

        return productRepo.save(product);
    }

    private Category findOrCreateCategory(String categoryName) {
        return Optional.ofNullable(categoryRepository.findByName(categoryName))
                .orElseGet(() -> new Category());
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
    public Product updateProductById(UpdateProductModel updateProduct, Long id) {
        return productRepo.findById(id).map((product) -> {
            updateExistingProduct(product, updateProduct);
            return product; // Return the updated product
        }).map(productRepo::save).orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + id));
    }

    //helper method for update 
    private Product updateExistingProduct(Product existingProd, UpdateProductModel updateRequest) {
        existingProd.setName(updateRequest.getName());
        existingProd.setBrand(updateRequest.getBrand());
        existingProd.setPrice(updateRequest.getPrice());
        existingProd.setInventory(updateRequest.getInventory());
        existingProd.setDescription(updateRequest.getDescription());
        existingProd.setName(updateRequest.getName());
        Category category = categoryRepository.findByName(updateRequest.getCategory().getName());
        existingProd.setName(category.getName());
        existingProd.setCategory(category);
        return existingProd;
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
