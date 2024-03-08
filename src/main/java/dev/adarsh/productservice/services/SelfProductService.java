package dev.adarsh.productservice.services;

import dev.adarsh.productservice.dtos.ProductDto;
import dev.adarsh.productservice.exceptions.NotFoundException;
import dev.adarsh.productservice.models.Category;
import dev.adarsh.productservice.models.Product;
import dev.adarsh.productservice.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service(value = "selfProductService")
public class SelfProductService implements ProductService{
    private ProductRepository productRepository;
    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> getSingleProduct(Long productId) throws NotFoundException {
        Product product= productRepository.findProductById(productId);
        if(product== null){
            throw new NotFoundException("Product doesn't exist");
        }
        return Optional.of(product);
    }

    @Override
    public Product addNewProduct(ProductDto product) {
        Product product1=convertProductDtoToProduct(product);
//        return productRepository.save(product1);
        return null;
    }

    @Override
    public Product updateProduct(Long productId, Product product) {

//        return productRepository.save(productId,product);
        return null;
    }

    @Override
    public Product replaceProduct(Long productId, Product product) {
//        return productRepository.save(productId,product);
        return null;
    }


    @Override
    public boolean deleteProduct(Long productId) {
        productRepository.deleteById(productId);
        return false;
    }

    private Product convertProductDtoToProduct(ProductDto productDto){
        Product product=new Product();
        product.setId(productDto.getId());
        product.setTitle(productDto.getTitle());
        product.setPrice(productDto.getPrice());
        Category category = new Category();
        category.setName(productDto.getCategory());
        product.setCategory(category);
        product.setImageUrl(productDto.getImage());
        return product;
    }
}
