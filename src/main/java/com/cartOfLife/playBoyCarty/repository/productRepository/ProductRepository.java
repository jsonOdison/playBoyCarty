package com.cartOfLife.playBoyCarty.repository.productRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cartOfLife.playBoyCarty.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
