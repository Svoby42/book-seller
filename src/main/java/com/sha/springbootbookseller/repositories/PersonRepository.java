package com.sha.springbootbookseller.repositories;

import com.sha.springbootbookseller.entities.Person;
import com.sha.springbootbookseller.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {

    Optional<Person> findByUsername(String username);

    @Modifying
    @Query("update Person set role = :role where username = :username ")
    void updateUserRole(@Param("username") String username, @Param("role") Role role);

}
