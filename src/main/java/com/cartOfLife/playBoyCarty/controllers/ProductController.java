package com.cartOfLife.playBoyCarty.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cartOfLife.playBoyCarty.exception.ProductNotFoundException;
import com.cartOfLife.playBoyCarty.model.Product;
import com.cartOfLife.playBoyCarty.response.ApiResponse;
import com.cartOfLife.playBoyCarty.services.products.iProductService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("${api.prefix}/products")
public class ProductController {

    @Autowired
    private final iProductService productService;

    // @PostMapping
    // public ResponseEntity<ApiResponse> addProduct(@RequestBody AddProductModel requestProduct) {
    //     Product product = productService.addProduct(requestProduct);
    //     return ResponseEntity.status(HttpStatus.CREATED)
    //             .body(new ApiResponse("Product added successfully!", product));
    // }
    @GetMapping
    public ResponseEntity<ApiResponse> getAllProducts() {
        List<Product> products = productService.getAProducts();
        return ResponseEntity.ok(new ApiResponse("Products retrieved successfully!", products));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getProductById(@PathVariable Long id) {
        try {
            Product product = productService.getProductById(id);
            return ResponseEntity.ok(new ApiResponse("Product found!", product));
        } catch (ProductNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse(e.getMessage(), null));
        }
    }

    // @PutMapping("/{id}")
    // public ResponseEntity<ApiResponse> updateProduct(@RequestBody UpdateProductModel updateProduct, @PathVariable Long id) {
    //     try {
    //         Product updatedProduct = productService.updateProductById(updateProduct, id);
    //         return ResponseEntity.ok(new ApiResponse("Product updated successfully!", updatedProduct));
    //     } catch (ProductNotFoundException e) {
    //         return ResponseEntity.status(HttpStatus.NOT_FOUND)
    //                 .body(new ApiResponse(e.getMessage(), null));
    //     }
    // }
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteProductById(@PathVariable Long id) {
        try {
            productService.deleteProductById(id, null);
            return ResponseEntity.ok(new ApiResponse("Product deleted successfully!", null));
        } catch (ProductNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse(e.getMessage(), null));
        }
    }

    // @GetMapping("/category/{category}")
    // public ResponseEntity<ApiResponse> getProductsByCategory(@PathVariable String category) {
    //     // List<Product> products = productService.getProductByCategory(null, category);
    //     List<Product> products = new ArrayList();
    //     return ResponseEntity.ok(new ApiResponse("Products retrieved by category successfully!", products));
    // }
    // @GetMapping("/brand/{brand}")
    // public ResponseEntity<ApiResponse> getProductsByBrand(@PathVariable String brand) {
    //     // List<Product> products = productService.getProductByBrand(brand);
    //     List<Product> products = new ArrayList<>();
    //     return ResponseEntity.ok(new ApiResponse("Products retrieved by brand successfully!", products));
    // }
    // @GetMapping("/category-brand")
    // public ResponseEntity<ApiResponse> getProductsByCategoryAndBrand(
    //         @RequestParam String category,
    //         @RequestParam String brand) {
    //     List<Product> products = productService.getProductByCategoryAndBrand(category, brand);
    //     return ResponseEntity.ok(new ApiResponse("Products retrieved by category and brand successfully!", products));
    // }
    // @GetMapping("/name/{name}")
    // public ResponseEntity<ApiResponse> getProductsByName(@PathVariable String name) {
    //     // List<Product> products = productService.getProductByName(name);
    //     List<Product> products = new ArrayList<>();
    //     return ResponseEntity.ok(new ApiResponse("Products retrieved by name successfully!", products));
    // }
    // @GetMapping("/brand-name")
    // public ResponseEntity<ApiResponse> getProductsByBrandAndName(
    //         @RequestParam String category,
    //         @RequestParam String brand) {
    //     List<Product> products = new ArrayList<>();
    //     return ResponseEntity.ok(new ApiResponse("Products retrieved by brand and name successfully!", products));
    // }
    // @GetMapping("/count")
    // public ResponseEntity<ApiResponse> countProductsByBrandAndName(
    //         @RequestParam String brand,
    //         @RequestParam String name) {
    //     Long count = productService.countProductsByBranndAndName(brand, name);
    //     return ResponseEntity.ok(new ApiResponse("Product count retrieved successfully!", count));
    // }
}
