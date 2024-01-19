package dev.adarsh.productservice.services;

import dev.adarsh.productservice.clients.fakestoreapi.FakeStoreClient;
import dev.adarsh.productservice.clients.fakestoreapi.FakeStoreProductDto;
import dev.adarsh.productservice.dtos.ProductDto;
import dev.adarsh.productservice.models.Category;
import dev.adarsh.productservice.models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class FakeStoreProductServiceImp implements ProductService{
    private FakeStoreClient fakeStoreClient;
    public FakeStoreProductServiceImp( FakeStoreClient fakeStoreClient){
        this.fakeStoreClient=fakeStoreClient;
    }

    @Override
    public List<Product> getAllProduct() {
        List<FakeStoreProductDto>  fakeStoreProductDtos=fakeStoreClient.getAllProduct();
        List<Product> productList=new ArrayList<>();
        for(FakeStoreProductDto productDto:fakeStoreProductDtos){
            productList.add(convertFakeStoreProdctDtoToProduct(Optional.ofNullable(productDto)));
        }
        return productList;
    }


    @Override
    public Optional<Product> getSingleProduct(Long productId) {
        Optional<FakeStoreProductDto> productDto=fakeStoreClient.getSingleProduct(productId);
        if(productDto==null){
            return Optional.empty();
        }else{
        Product product=convertFakeStoreProdctDtoToProduct(productDto);

        return Optional.of(product);
        }
    }

    @Override
    public Product addNewProduct(ProductDto productDto) {
        FakeStoreProductDto productDtoResponse=fakeStoreClient.addNewProduct(productDto);
        return convertFakeStoreProdctDtoToProduct(Optional.ofNullable(productDtoResponse));
    }

    @Override
    public Product updateProduct(Long productId, Product product) {
        FakeStoreProductDto fakeStoreProductDto= fakeStoreClient.updateProduct(productId,product);
        return convertFakeStoreProdctDtoToProduct(Optional.ofNullable(fakeStoreProductDto));
    }

    @Override
    public Product replaceProduct(Long productId, Product product) {
        FakeStoreProductDto fakeStoreProductDto= fakeStoreClient.replaceProduct(productId,product);
        return convertFakeStoreProdctDtoToProduct(Optional.ofNullable(fakeStoreProductDto));
    }

    @Override
    public boolean deleteProduct(Long productId) {

        return fakeStoreClient.deleteProduct(productId);
    }
    private Product convertFakeStoreProdctDtoToProduct(Optional<FakeStoreProductDto> productDto){
        Product product=new Product();
        product.setId(productDto.get().getId());
        product.setTitle(productDto.get().getTitle());
        product.setPrice(productDto.get().getPrice());
        product.setDescription(productDto.get().getDescription());
        product.setImageUrl(productDto.get().getImage());
        Category category=new Category();
        category.setName(productDto.get().getCategory());
        product.setCategory(category);

        return product;
    }
}
