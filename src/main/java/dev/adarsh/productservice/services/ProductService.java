package dev.adarsh.productservice.services;

import dev.adarsh.productservice.dtos.ProductDto;
import dev.adarsh.productservice.models.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ProductService {

    List<Product> getAllProduct();


    Product getSingleProduct( Long productId);

    Product addNewProduct( ProductDto product);

    Product updateProduct( Long productId, Product product);

    boolean deleteProduct( Long productId);
}
