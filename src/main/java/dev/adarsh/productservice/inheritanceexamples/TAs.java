package dev.adarsh.productservice.inheritanceexamples;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TAs extends Users{
    private double averageRating;
}
