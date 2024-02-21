package dev.adarsh.productservice;

import dev.adarsh.productservice.models.Category;
import dev.adarsh.productservice.models.Product;
import dev.adarsh.productservice.repositories.CategoryRepository;
import dev.adarsh.productservice.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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


        Category category=new Category();
        category.setName("phones");
        //Category savedCategory=categoryRepository.save(category);

        Product product=new Product();
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

    @Test
    void deleteProduct(){
        productRepository.deleteById(1L);
    }

    @Test
    @Transactional
    @Rollback(value = false)
    void saveProductForCategory(){
        Category category=categoryRepository.findById(2L).get();

        Product product=new Product();
        product.setPrice(1003);
        product.setTitle("Apple");
        product.setImageUrl("Hello");
        product.setCategory(category);
        productRepository.save(product);

        product=new Product();
        product.setPrice(1000);
        product.setTitle("Apple");
        product.setImageUrl("Hello");
        product.setCategory(category);
        productRepository.save(product);
    }

    @Test
    @Transactional
    void getProductFromCategory(){

//        Category category=categoryRepository.findById(2L).get();
//
//        for(Product product: category.getProducts()){
//            System.out.println(product.getPrice());
//        }

        List<Category> categories= categoryRepository.findAllByIdIn(List.of(2L,1L));
        for(Category category:categories){
            for(Product product:category.getProducts()){
                System.out.println(product.getPrice());
            }
        }
    }

    @Test
    @Transactional
    void getProductFrom1Category(){

        Category category=categoryRepository.findById(2L).get();

        for(Product product: category.getProducts()){
            System.out.println(product.getPrice());
        }

    }
}
