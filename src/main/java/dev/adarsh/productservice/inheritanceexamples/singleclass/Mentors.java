package dev.adarsh.productservice.inheritanceexamples.singleclass;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "st_mentor")
@DiscriminatorValue(value = "3")
public class Mentors extends Users {
    private int numberOfSessions;
    private int numberOfMentees;
}
