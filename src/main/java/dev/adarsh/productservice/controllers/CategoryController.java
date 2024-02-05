package dev.adarsh.productservice.controllers;

import dev.adarsh.productservice.models.Product;
import dev.adarsh.productservice.services.CategoriesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {
    private CategoriesService categoriesService;
    public CategoryController(CategoriesService categoriesService){
        this.categoriesService=categoriesService;
    }
    @GetMapping("products/categories")
    public String getAllCategory(){

       return  categoriesService.getAllCategory();
    }

    @GetMapping("/products/categories/{categoryId}")
    public List<Product> getProductsInCategory(@PathVariable ("categoryId") String categoryName){
        return categoriesService.getProductsInCategory(categoryName);
    }


}
