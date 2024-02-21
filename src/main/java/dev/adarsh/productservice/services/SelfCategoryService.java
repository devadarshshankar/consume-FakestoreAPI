package dev.adarsh.productservice.services;

import dev.adarsh.productservice.models.Product;
import dev.adarsh.productservice.repositories.CategoryRepository;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class SelfCategoryService implements CategoriesService{
    private CategoryRepository categoryRepository;
    @Override
    public String getAllCategory() {
        return categoryRepository.findAll().toString();
    }

    @Override
    public List<Product> getProductsInCategory(String categoryName) {
        return null;
    }

//    @Override
//    public List<Product> getProductsInCategory(String categoryName) {
//        return categoryRepository.findAllByNameIn(categoryName);
//    }
}
