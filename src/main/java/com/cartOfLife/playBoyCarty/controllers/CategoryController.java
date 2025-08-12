// package com.cartOfLife.playBoyCarty.controllers;

// import java.util.List;

// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.cartOfLife.playBoyCarty.exception.AlreadyExistException;
// import com.cartOfLife.playBoyCarty.exception.CategoryNotFoundException;
// import com.cartOfLife.playBoyCarty.model.Category;
// import com.cartOfLife.playBoyCarty.response.ApiResponse;
// import com.cartOfLife.playBoyCarty.services.category.ICategoryService;

// import lombok.RequiredArgsConstructor;

// @RequiredArgsConstructor
// @RestController
// @RequestMapping("${api.prefix}/categories")
// public class CategoryController {

//     private final ICategoryService categoryService;

//     @GetMapping
//     public ResponseEntity<ApiResponse> getAllCategories() {
//         try {
//             List<Category> categories = categoryService.getAllCategories();
//             return ResponseEntity.ok(new ApiResponse("Categories retrieved successfully!", categories));
//         } catch (Exception e) {
//             return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                     .body(new ApiResponse("Error retrieving categories", e.getMessage()));
//         }
//     }

//     @GetMapping("/{id}")
//     public ResponseEntity<ApiResponse> getCategoryById(@PathVariable Long id) {
//         try {
//             Category category = categoryService.getCategoryById(id);
//             return ResponseEntity.ok(new ApiResponse("Category found!", category));
//         } catch (CategoryNotFoundException e) {
//             return ResponseEntity.status(HttpStatus.NOT_FOUND)
//                     .body(new ApiResponse(e.getMessage(), null));
//         }
//     }

//     // @GetMapping("/name/{name}")
//     // public ResponseEntity<ApiResponse> getCategoryByName(@PathVariable String name) {
//     //     Category category = categoryService.getCategoryByName(name);
//     //     if (category != null) {
//     //         return ResponseEntity.ok(new ApiResponse("Category found!", category));
//     //     } else {
//     //         return ResponseEntity.status(HttpStatus.NOT_FOUND)
//     //                 .body(new ApiResponse("Category not found with name: " + name, null));
//     //     }
//     // }
//     @PostMapping
//     public ResponseEntity<ApiResponse> addCategory(@RequestBody Category category) {
//         try {
//             Category savedCategory = categoryService.addCategor(category);
//             return ResponseEntity.status(HttpStatus.CREATED)
//                     .body(new ApiResponse("Category added successfully!", savedCategory));
//         } catch (AlreadyExistException e) {
//             return ResponseEntity.status(HttpStatus.CONFLICT)
//                     .body(new ApiResponse(e.getMessage(), null));
//         }
//     }

//     @PutMapping("/{id}")
//     public ResponseEntity<ApiResponse> updateCategory(@RequestBody Category category, @PathVariable Long id) {
//         try {
//             Category updatedCategory = categoryService.updateCategory(category, id);
//             return ResponseEntity.ok(new ApiResponse("Category updated successfully!", updatedCategory));
//         } catch (CategoryNotFoundException e) {
//             return ResponseEntity.status(HttpStatus.NOT_FOUND)
//                     .body(new ApiResponse(e.getMessage(), null));
//         }
//     }

//     @DeleteMapping("/{id}")
//     public ResponseEntity<ApiResponse> deleteCategoryById(@PathVariable Long id) {
//         try {
//             categoryService.deleteCategoryById(id);
//             return ResponseEntity.ok(new ApiResponse("Category deleted successfully!", null));
//         } catch (CategoryNotFoundException e) {
//             return ResponseEntity.status(HttpStatus.NOT_FOUND)
//                     .body(new ApiResponse(e.getMessage(), null));
//         }
//     }
// }
