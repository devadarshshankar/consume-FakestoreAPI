package dev.adarsh.productservice.services;

import dev.adarsh.productservice.models.Product;

import java.util.List;

public interface CategoriesService {

    String getAllCategory();


    List<Product> getProductsInCategory(String categoryName);
}
