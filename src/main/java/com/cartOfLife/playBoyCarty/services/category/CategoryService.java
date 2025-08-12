// package com.cartOfLife.playBoyCarty.services.category;

// import java.util.List;
// import java.util.Optional;

// import org.springframework.stereotype.Service;

// import com.cartOfLife.playBoyCarty.exception.CategoryNotFoundException;
// import com.cartOfLife.playBoyCarty.model.Category;
// import com.cartOfLife.playBoyCarty.repository.categoryRepository.CategoryRepository;

// import lombok.RequiredArgsConstructor;

// @Service
// @RequiredArgsConstructor
// public class CategoryService implements ICategoryService {

//     private final CategoryRepository categoryRepository;

//     @Override
//     public Category getCategoryById(Long id) {
//         return categoryRepository.findById(id).orElseThrow(() -> new CategoryNotFoundException("Category not found with ID:  " + id));
//     }

//     // @Override
//     // public Category getCategoryByName(String name) {
//     //     return categoryRepository.findByName(name);
//     // }
//     @Override
//     public List<Category> getAllCategories() {
//         return categoryRepository.findAll();
//     }

//     // @Override
//     // public Category addCategor(Category category) {
//     //     return Optional.of(category)
//     //             .filter(c -> !categoryRepository.existsByName(c.getName()))
//     //             .map(categoryRepository::save)
//     //             .orElseThrow(() -> new AlreadyExistException("Category already exists"));
//     // }
//     @Override
//     public Category updateCategory(Category category, Long id) {
//         return Optional.ofNullable(getCategoryById(id)).map(oldCategory -> {
//             oldCategory.setName(category.getName());
//             return categoryRepository.save(oldCategory);
//         }).orElseThrow(() -> new CategoryNotFoundException("Category not found with ID: " + id));
//     }

//     @Override
//     public void deleteCategoryById(Long id) {
//         categoryRepository.findById(id).ifPresentOrElse(categoryRepository::delete, () -> new CategoryNotFoundException("Category not found with ID:" + id));
//     }

//     @Override
//     public Category addCategor(Category category) {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'addCategor'");
//     }

// }
