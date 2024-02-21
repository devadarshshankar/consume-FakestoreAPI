package dev.adarsh.productservice.inheritanceexamples.mappedsuperclass;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "ms_mentor")
public class Mentors extends Users {
    private int numberOfSessions;
    private int numberOfMentees;
}
