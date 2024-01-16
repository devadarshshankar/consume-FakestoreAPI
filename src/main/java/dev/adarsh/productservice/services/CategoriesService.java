package dev.adarsh.productservice.services;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface CategoriesService {

    String getAllCategory();


    String getProductsInCategory(long productId);
}
