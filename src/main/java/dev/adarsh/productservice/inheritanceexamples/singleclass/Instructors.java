package dev.adarsh.productservice.inheritanceexamples.singleclass;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "st_Instructor")
@DiscriminatorValue(value = "2")
public class Instructors extends Users {
    private boolean isHandsome;
}
