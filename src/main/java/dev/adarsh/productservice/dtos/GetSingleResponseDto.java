package dev.adarsh.productservice.dtos;

import dev.adarsh.productservice.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetSingleResponseDto {
    private Product product;
}
