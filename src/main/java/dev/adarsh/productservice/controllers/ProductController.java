package dev.adarsh.productservice.controllers;

import dev.adarsh.productservice.dtos.ProductDto;
import dev.adarsh.productservice.services.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products") //-->we can remove "/products" from all the mapping now
public class ProductController {
    private ProductService productService;
    public ProductController(ProductService productService){
        this.productService=productService;
    }

   // @GetMapping("/products")
    @GetMapping()
    public String getAllProduct(){
        return "Getting all product ";
    }

    @GetMapping("/{productId}")
    public String getSingleProduct(@PathVariable("productId") Long productId){
        return "returning single product with id: "+productId;
    }

    @PostMapping()
    public String addNewProduct(@RequestBody ProductDto productDto){
        return "Adding new Product with "+productDto;
    }

    @PutMapping("/{productId}")
    public String updateProduct(@PathVariable("productId") Long productId){
        return "Updating the product with id: "+productId;
    }

    @DeleteMapping("/{productId}")
    public String deleteProduct(@PathVariable("productId") Long productId){
        return "Deleting a product with id: "+productId;
    }
}
