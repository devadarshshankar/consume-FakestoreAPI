package dev.adarsh.productservice.inheritanceexamples.singleclass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SC_UserRepository extends JpaRepository<Users, Long> {
    Users save(Users user);
    Users findUsersById(Long id);
}
