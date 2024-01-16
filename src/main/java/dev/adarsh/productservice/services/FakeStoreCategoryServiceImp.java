package dev.adarsh.productservice.services;

import org.springframework.stereotype.Service;

@Service // we can use @Controller/ @Repositories or any other stereotype annotation as the main purpose of these are to create beans
public class FakeStoreCategoryServiceImp implements CategoriesService{
    @Override
    public String getAllCategory() {
        return null;
    }

    @Override
    public String getProductsInCategory(long productId) {
        return null;
    }
}
