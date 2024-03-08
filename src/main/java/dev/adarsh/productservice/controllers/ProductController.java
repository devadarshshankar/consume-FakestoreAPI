package dev.adarsh.productservice.controllers;

import dev.adarsh.productservice.dtos.ErrorResponseDto;
import dev.adarsh.productservice.dtos.GetSingleResponseDto;
import dev.adarsh.productservice.dtos.ProductDto;
import dev.adarsh.productservice.exceptions.NotFoundException;
import dev.adarsh.productservice.models.Category;
import dev.adarsh.productservice.models.Product;
import dev.adarsh.productservice.repositories.ProductRepository;
import dev.adarsh.productservice.services.ProductService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/products") //-->we can remove "/products" from all the mapping now
public class ProductController {
    private ProductService productService;
    private ProductRepository productRepository;
    public ProductController(@Qualifier(value = "fakeStoreProductService") ProductService productService, ProductRepository productRepository){
        this.productService=productService;
        this.productRepository=productRepository;
    }

   // @GetMapping("/products")
    @GetMapping()
    public List<Product> getAllProduct(){
        List<Product> products=productService.getAllProduct();
//        products.get(0).setPrice(100);
        return products;
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> getSingleProduct(@PathVariable("productId") Long productId) throws NotFoundException{

        MultiValueMap<String,String> headers=new LinkedMultiValueMap<>();
        headers.add("auth-token","noToken4uHeyHey");

        Optional<Product> productOptional= productService.getSingleProduct(productId);
        if(productOptional.isEmpty()){
            throw  new NotFoundException("No Product with product id: "+productId);
        }

        ResponseEntity<Product> response=new ResponseEntity<>
                (productService.getSingleProduct(productId).get(),
                headers,
                HttpStatus.NOT_FOUND);
        return response;

    }

    @PostMapping()
    public ResponseEntity<Product> addNewProduct(@RequestBody ProductDto product){
        Product newProduct= new Product();
        newProduct.setDescription(product.getDescription());
        newProduct.setImageUrl(product.getImage());
        newProduct.setPrice(product.getPrice());
        newProduct.setTitle(product.getTitle());

        newProduct=productRepository.save(newProduct);
        ResponseEntity<Product> response=new ResponseEntity<>(newProduct,HttpStatus.OK);
        return response;
    }

    @PutMapping("/{productId}")
    public Product updateProduct(@PathVariable("productId") Long productId,@RequestBody ProductDto productDto){
        Product product=new Product();
        product.setId(productDto.getId());
        product.setCategory(new Category());
        product.getCategory().setName(productDto.getCategory());
        product.setTitle(productDto.getTitle());
        product.setPrice(productDto.getPrice());
        product.setImageUrl(productDto.getImage());

        return productService.replaceProduct(productId,product);
    }
    @PatchMapping("/{productId}")
    public Product updateProductviaPatch(@PathVariable("productId") Long productId,@RequestBody ProductDto productDto){
        Product product=new Product();
        product.setId(productDto.getId());
        product.setCategory(new Category());
        product.getCategory().setName(productDto.getCategory());
        product.setTitle(productDto.getTitle());
        product.setPrice(productDto.getPrice());
        product.setImageUrl(productDto.getImage());

        return productService.updateProduct(productId,product);
    }

    @DeleteMapping("/{productId}")
    public String deleteProduct(@PathVariable("productId") Long productId){
        return "Deleting a product with id: "+productId;
    }


}
