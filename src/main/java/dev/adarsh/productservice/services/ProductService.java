package dev.adarsh.productservice.services;

import dev.adarsh.productservice.dtos.ProductDto;
import dev.adarsh.productservice.exceptions.NotFoundException;
import dev.adarsh.productservice.models.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> getAllProduct();


    Optional<Product> getSingleProduct(Long productId) throws NotFoundException;

    Product addNewProduct( ProductDto product);

    Product updateProduct( Long productId, Product product);
    Product replaceProduct(Long productId,Product product);

    boolean deleteProduct( Long productId);
}
