package com.cartOfLife.playBoyCarty.repository.productRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cartOfLife.playBoyCarty.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByCategoryName(String category);

    public List<Product> findByBrandName(String brand);

    public List<Product> findByProductByCategoryAndBrand(String categoroy, String brand);

}
