package dev.adarsh.productservice.inheritanceexamples.joinedtable;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JT_MentorsRepository extends JpaRepository<Mentors,Long> {
    Mentors save(Mentors mentors);
    Mentors findMentorsById(Long id);
}
