package dev.adarsh.productservice.inheritanceexamples.mappedsuperclass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MS_MentorsRepository extends JpaRepository<Mentors,Long> {
    Mentors save(Mentors mentors);
    Mentors findMentorsById(Long id);
}
