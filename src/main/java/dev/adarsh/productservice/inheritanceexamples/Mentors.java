package dev.adarsh.productservice.inheritanceexamples;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Mentors extends Users{
    private int numberOfSessions;
    private int numberOfMentees;
}
