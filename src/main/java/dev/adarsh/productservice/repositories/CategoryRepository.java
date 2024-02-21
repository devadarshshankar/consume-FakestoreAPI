package dev.adarsh.productservice.repositories;

import dev.adarsh.productservice.models.Category;
import dev.adarsh.productservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Long> {
    Category save(Category category);

    List<Category> findAllByIdIn(List<Long> ids);

//    List<Product> findAllByNameIn(String categoryName);

}
