package com.cartOfLife.playBoyCarty.services.category;

import java.util.List;

import com.cartOfLife.playBoyCarty.model.Category;

public interface ICategoryService {

    Category getCategoryById(Long id);

    Category getCategoryByName(String name);

    List<Category> getAllCategories();

    Category addCategor(Category category);

    Category updateCategory(Category category, Long id);

    void deleteCategoryById(Long id);
}
