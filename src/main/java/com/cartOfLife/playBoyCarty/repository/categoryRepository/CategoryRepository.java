package com.cartOfLife.playBoyCarty.repository.categoryRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cartOfLife.playBoyCarty.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category findByName(String name);

    boolean existsByName(String name);

}
