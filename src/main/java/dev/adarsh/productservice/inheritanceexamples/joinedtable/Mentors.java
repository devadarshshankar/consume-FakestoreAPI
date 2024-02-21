package dev.adarsh.productservice.inheritanceexamples.joinedtable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "jt_mentor")
@PrimaryKeyJoinColumn(name = "user_id")
public class Mentors extends Users {
    private int numberOfSessions;
    private int numberOfMentees;
}
