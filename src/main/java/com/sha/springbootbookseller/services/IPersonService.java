package com.sha.springbootbookseller.services;

import com.sha.springbootbookseller.entities.Person;

import java.util.Optional;

public interface IPersonService {
    Person savePerson(Person person);

    Optional<Person> findByUsername(String username);

    void makeAdmin(String username);
}
