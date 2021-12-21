package com.sha.springbootbookseller.services;

import com.sha.springbootbookseller.entities.Person;

public interface IPersonService {
    Person savePerson(Person person);

    void makeAdmin(String username);
}
