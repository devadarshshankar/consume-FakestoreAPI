package dev.adarsh.productservice.services;

import dev.adarsh.productservice.dtos.ProductDto;
import dev.adarsh.productservice.models.Category;
import dev.adarsh.productservice.models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class FakeStoreProductServiceImp implements ProductService{

    private RestTemplateBuilder restTemplateBuilder;
    public FakeStoreProductServiceImp(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder=restTemplateBuilder;
    }

    @Override
    public List<Product> getAllProduct() {
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<ProductDto[]> response=restTemplate.getForEntity("https://fakestoreapi.com/products",
                ProductDto[].class);

        List<Product> productList=new ArrayList<>();
        for(ProductDto productDto:response.getBody()){
            Product product=new Product();
            product.setId(productDto.getId());
            product.setTitle(productDto.getTitle());
            product.setPrice(productDto.getPrice());
            product.setDescription(productDto.getDescription());
            product.setImageUrl(product.getImageUrl());
            Category category=new Category();
            category.setName(productDto.getCategory());
            product.setCategory(category);

            productList.add(product);
        }

//        ResponseEntity<List> response=restTemplate.getForEntity("https://fakestoreapi.com/products",
//                List.class);
//        for(Object obj: response.getBody()){
//            Map<String,Object> hm= (Map<String, Object>) obj;
//
//            Product product= new Product();
//            product.setId(Long.valueOf((Integer)(hm.get("id"))));
//            product.setTitle((String) hm.get("title"));
//            product.setPrice(Double.valueOf( hm.get("price").toString()));
//            product.setDescription((String) hm.get("description"));
//            product.setImageUrl((String) hm.get("image"));
//            Category category=new Category();
//            category.setName((String) hm.get("category"));
//            product.setCategory(category);
//
//            productList.add(product);
//        }
        return productList;
    }

    @Override
    public Product getSingleProduct(Long productId) {
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<ProductDto> response= restTemplate.getForEntity(
                "https://fakestoreapi.com/products/{id}",
                ProductDto.class,productId);

        ProductDto productDto=response.getBody();
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

    @Override
    public Product addNewProduct(ProductDto productDto) {
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<ProductDto> response=restTemplate.postForEntity(
                "https://fakestoreapi.com/products",
                productDto,
                ProductDto.class);

        ProductDto productDtoResponse=response.getBody();
        Product product=new Product();
        product.setId(productDtoResponse.getId());
        product.setTitle(productDtoResponse.getTitle());
        product.setPrice(productDtoResponse.getPrice());
        product.setDescription(productDtoResponse.getDescription());
        product.setImageUrl(productDtoResponse.getImage());
        Category category=new Category();
        category.setName(productDtoResponse.getCategory());
        product.setCategory(category);

        return product;

    }

    @Override
    public Product updateProduct(Long productId, Product product) {
        return null;
    }

    @Override
    public boolean deleteProduct(Long productId) {
        return false;
    }
}
