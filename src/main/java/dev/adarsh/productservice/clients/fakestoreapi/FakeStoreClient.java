package dev.adarsh.productservice.clients.fakestoreapi;

import dev.adarsh.productservice.dtos.ProductDto;
import dev.adarsh.productservice.models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class FakeStoreClient {
    private RestTemplateBuilder restTemplateBuilder;
    public FakeStoreClient(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder=restTemplateBuilder;
    }
    public List<FakeStoreProductDto> getAllProduct(){
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto[]> response=restTemplate.getForEntity("https://fakestoreapi.com/products",
                FakeStoreProductDto[].class);
        return Arrays.asList(response.getBody());
    }


    public Optional<FakeStoreProductDto> getSingleProduct(Long productId){
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response= restTemplate.getForEntity(
                "https://fakestoreapi.com/products/{id}",
                FakeStoreProductDto.class,productId);
        return Optional.ofNullable(response.getBody());
    }

    public FakeStoreProductDto addNewProduct( ProductDto productDto){
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response=restTemplate.postForEntity(
                "https://fakestoreapi.com/products",
                productDto,
                FakeStoreProductDto.class);
        return response.getBody();
    }

    public FakeStoreProductDto updateProduct( Long productId, Product product){
        FakeStoreProductDto fakeStoreProductDto=new FakeStoreProductDto();
        fakeStoreProductDto.setImage(product.getImageUrl());
        fakeStoreProductDto.setDescription(product.getDescription());
        fakeStoreProductDto.setTitle(product.getTitle());
        fakeStoreProductDto.setPrice(product.getPrice());
        fakeStoreProductDto.setCategory(product.getCategory().getName());

        ResponseEntity<FakeStoreProductDto> fakeStoreProductDtoResponseEntity= requestForEntity(HttpMethod.PATCH,
                "https://fakestoreapi.com/products/{id}",
                fakeStoreProductDto,
                FakeStoreProductDto.class,
                productId
        );
        return fakeStoreProductDtoResponseEntity.getBody();
    }
    public FakeStoreProductDto replaceProduct(Long productId,Product product){
        FakeStoreProductDto fakeStoreProductDto=new FakeStoreProductDto();
        fakeStoreProductDto.setId(product.getId());
        fakeStoreProductDto.setDescription(product.getDescription());
        fakeStoreProductDto.setTitle(product.getTitle());
        fakeStoreProductDto.setPrice(product.getPrice());
        fakeStoreProductDto.setCategory(product.getCategory().getName());
        fakeStoreProductDto.setImage(product.getImageUrl());

        ResponseEntity<FakeStoreProductDto> fakeStoreProductDtoResponseEntity=requestForEntity
                (HttpMethod.PUT,
                        "https://fakestoreapi.com/products/{id}",
                        fakeStoreProductDto,
                        FakeStoreProductDto.class,
                        productId);
        return fakeStoreProductDtoResponseEntity.getBody();
    }
    public boolean deleteProduct( Long productId){
        return false;
    }

    public String getAllCategory() {
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<String> response=restTemplate.getForEntity(
                "https://fakestoreapi.com/products/categories",
                String.class
        );
        return response.getBody();
    }

    public ResponseEntity<FakeStoreProductDto[]> getProductsInCategory(String categoryName) {
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto[]> fakeStoreProductDtoResponseEntity=restTemplate.
                getForEntity("https://fakestoreapi.com/products/category/{categoryName}",
                        FakeStoreProductDto[].class,
                        categoryName);

        return fakeStoreProductDtoResponseEntity;
    }

    private  <T> ResponseEntity<T>  requestForEntity(HttpMethod httpMethod, String url, @Nullable Object request, Class<T> responseType, Object... uriVariables) throws RestClientException {
        //   RestTemp  late restTemplate=restTemplateBuilder.build();// this is not working for PATCH request
        RestTemplate restTemplate=restTemplateBuilder.requestFactory
                (HttpComponentsClientHttpRequestFactory.class).build();
        RequestCallback requestCallback = restTemplate.httpEntityCallback(request, responseType);
        ResponseExtractor<ResponseEntity<T>> responseExtractor = restTemplate.responseEntityExtractor(responseType);
        return restTemplate.execute(url, httpMethod, requestCallback, responseExtractor, uriVariables);
    }
}
