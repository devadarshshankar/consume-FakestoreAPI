package dev.adarsh.productservice.inheritanceexamples.singleclass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SC_MentorsRepository extends JpaRepository<Mentors,Long> {
    Mentors save(Mentors mentors);
    Mentors findMentorsById(Long id);
}
