package dev.adarsh.productservice.controllers;

import dev.adarsh.productservice.dtos.GetSingleResponseDto;
import dev.adarsh.productservice.dtos.ProductDto;
import dev.adarsh.productservice.models.Product;
import dev.adarsh.productservice.services.ProductService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/products") //-->we can remove "/products" from all the mapping now
public class ProductController {
    private ProductService productService;
    public ProductController(ProductService productService){
        this.productService=productService;
    }

   // @GetMapping("/products")
    @GetMapping()
    public List<Product> getAllProduct(){
        return productService.getAllProduct();
//        return "Getting all product ";
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> getSingleProduct(@PathVariable("productId") Long productId){

        MultiValueMap<String,String> headers=new LinkedMultiValueMap<>();
        headers.add("auth-token","noToken4uHeyHey");
        ResponseEntity<Product> response=new ResponseEntity<>(productService.getSingleProduct(productId),
                headers,
                HttpStatus.NOT_FOUND);
        return response;
//        GetSingleResponseDto responseDto=new GetSingleResponseDto();
//        responseDto.setProduct(productService.getSingleProduct(productId));
//        return responseDto;
       // return productService.getSingleProduct(productId);
        //return "returning single product with id: "+productId;
    }

    @PostMapping()
    public ResponseEntity<Product> addNewProduct(@RequestBody ProductDto product){
        ResponseEntity<Product> response=new ResponseEntity<>(productService.addNewProduct(product),HttpStatus.OK);
        return response;
        //        return "Adding new Product with "+productDto;
    }

    @PutMapping("/{productId}")
    public String updateProduct(@PathVariable("productId") Long productId,@RequestBody ProductDto productDto){
        return "Updating the product with id: "+productId+" with body: "+productDto;
    }
    @PatchMapping("/{productId}")
    public String updateProductviaPatch(@PathVariable("productId") Long productId,@RequestBody ProductDto productDto){
        return "Updating the product with id: "+productId+" with body: "+productDto;
    }

    @DeleteMapping("/{productId}")
    public String deleteProduct(@PathVariable("productId") Long productId){
        return "Deleting a product with id: "+productId;
    }
}
