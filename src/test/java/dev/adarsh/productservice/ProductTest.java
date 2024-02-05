package dev.adarsh.productservice;

import dev.adarsh.productservice.models.Category;
import dev.adarsh.productservice.models.Product;
import dev.adarsh.productservice.repositories.CategoryRepository;
import dev.adarsh.productservice.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class ProductTest {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    void testFetchingTypes(){
//        Product product=new Product();
//        Category category=new Category();
//        category.setName("phones");
//        Category savedCategory=categoryRepository.save(category);
//
//        product.setPrice(1000);
//        product.setTitle("Apple");
//        product.setImageUrl("Hello");
//        product.setCategory(category);
//        productRepository.save(product);

        Product product=new Product();
        Category category=new Category();
        category.setName("phones");
        //Category savedCategory=categoryRepository.save(category);

        product.setPrice(1000);
        product.setTitle("Apple");
        product.setImageUrl("Hello");
        product.setCategory(category);
        productRepository.save(product);
    }

    @Test
    @Transactional
    void fetchTypesTest(){
        Product product=productRepository.findProductById(1L);

        System.out.println("Product Fetched");
        Category category=product.getCategory();

        String categoryName=category.getName();
    }
}
