package dev.adarsh.productservice.inheritanceexamples.joinedtable;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JT_UserRepository extends JpaRepository<Users, Long> {
    Users save(Users user);
    Users findUsersById(Long id);
}
