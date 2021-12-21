package com.sha.springbootbookseller.services;

import com.sha.springbootbookseller.entities.Person;
import com.sha.springbootbookseller.entities.Role;
import com.sha.springbootbookseller.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class PersonService implements IPersonService{

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Person savePerson(Person person){
        person.setPassword(passwordEncoder.encode(person.getPassword()));
        person.setRole(Role.USER);
        person.setCreateTime(LocalDateTime.now());

        return personRepository.save(person);
    }

    public Optional<Person> findByUsername(String username){
        return personRepository.findByUsername(username);
    }

    @Override
    @Transactional
    public void makeAdmin(String username){
        personRepository.updateUserRole(username, Role.ADMIN);
    }

}
