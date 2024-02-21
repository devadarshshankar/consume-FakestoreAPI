package dev.adarsh.productservice.inheritanceexamples.singleclass;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "st_ta")
@DiscriminatorValue(value="1")
public class TAs extends Users {
    private double averageRating;
}
