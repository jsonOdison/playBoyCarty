package com.cartOfLife.playBoyCarty.services.category;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cartOfLife.playBoyCarty.model.Category;
import com.cartOfLife.playBoyCarty.repository.categoryRepository.CategoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryService implements ICategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public Category getCategoryById(Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Category getCategoryByName(String name) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Category> getAllCategories() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Category addCategor(Category category) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Category updateCategory(Category category) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void deleteCategoryById(Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
