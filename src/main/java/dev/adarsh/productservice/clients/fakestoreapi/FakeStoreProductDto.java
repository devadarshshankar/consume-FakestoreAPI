package dev.adarsh.productservice.clients.fakestoreapi;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FakeStoreProductDto {
    private long id;
    private String title;
    private double price;
    private String description;
    private String image;
    private String category;
}
