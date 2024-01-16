package dev.adarsh.productservice.services;

import dev.adarsh.productservice.dtos.ProductDto;
import org.springframework.web.bind.annotation.*;

public interface ProductService {

    String getAllProduct();


    String getSingleProduct( Long productId);

    String addNewProduct( ProductDto productDto);

    String updateProduct( Long productId);

    String deleteProduct( Long productId);
}
