package dev.adarsh.productservice.inheritanceexamples.mappedsuperclass;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "ms_Instructor")
public class Instructors extends Users {
    private boolean isHandsome;
}
