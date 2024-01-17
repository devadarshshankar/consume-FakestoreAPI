package dev.adarsh.productservice.controllers;

import dev.adarsh.productservice.services.CategoriesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {
    private CategoriesService categoriesService;
    public CategoryController(CategoriesService categoriesService){
        this.categoriesService=categoriesService;
    }
    @GetMapping("products/categories")
    public String getAllCategory(){
        return "Getting all category";
    }

    @GetMapping("/products/categories/{categoryId}")
    public String getProductsInCategory(@PathVariable ("categoryId") long productId){
        return " Getting product in category";
    }

}
