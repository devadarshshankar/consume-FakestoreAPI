package dev.adarsh.productservice.services;

import dev.adarsh.productservice.clients.fakestoreapi.FakeStoreClient;
import dev.adarsh.productservice.clients.fakestoreapi.FakeStoreProductDto;
import dev.adarsh.productservice.models.Category;
import dev.adarsh.productservice.models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service // we can use @Controller/ @Repositories or any other stereotype annotation as the main purpose of these are to create beans
public class FakeStoreCategoryServiceImp implements CategoriesService{
    private RestTemplateBuilder restTemplateBuilder;
    private FakeStoreClient fakeStoreClient;
    public FakeStoreCategoryServiceImp(RestTemplateBuilder restTemplateBuilder, FakeStoreClient fakeStoreClient){
        this.restTemplateBuilder=restTemplateBuilder;
        this.fakeStoreClient=fakeStoreClient;
    }
    @Override
    public String getAllCategory() {

        return fakeStoreClient.getAllCategory();
    }

    @Override
    public List<Product> getProductsInCategory(String categoryName) {
        ResponseEntity<FakeStoreProductDto[]> fakeStoreProductDtoResponseEntity=fakeStoreClient.getProductsInCategory(categoryName);
        List<Product> productList=new ArrayList<>();
        for(FakeStoreProductDto fakeStoreProductDto:fakeStoreProductDtoResponseEntity.getBody()){
            Product product=convertFakeStoreProdctDtoToProduct(fakeStoreProductDto);
            productList.add(product);
        }
        return productList;
    }
    private Product convertFakeStoreProdctDtoToProduct(FakeStoreProductDto productDto){
        Product product=new Product();
        product.setId(productDto.getId());
        product.setTitle(productDto.getTitle());
        product.setPrice(productDto.getPrice());
        product.setDescription(productDto.getDescription());
        product.setImageUrl(product.getImageUrl());
        Category category=new Category();
        category.setName(productDto.getCategory());
        product.setCategory(category);

        return product;
    }
}
