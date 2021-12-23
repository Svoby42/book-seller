package com.sha.springbootbookseller.controller;

import com.sha.springbootbookseller.entities.Person;
import com.sha.springbootbookseller.services.IAuthenticationService;
import com.sha.springbootbookseller.services.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/authentication")
public class AuthenticationController {

    @Autowired
    private IAuthenticationService authenticationService;

    @Autowired
    private IPersonService personService;

    @PostMapping("/sign-up")
    public ResponseEntity<?> signUp(@RequestBody Person person){
        if(personService.findByUsername(person.getUsername()).isPresent()){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(personService.savePerson(person), HttpStatus.CREATED);
    }

    @PostMapping("/sign-in")
    public ResponseEntity<?> signIn(@RequestBody Person person){
        return new ResponseEntity<>(authenticationService.signInAndReturnJWT(person), HttpStatus.OK);
    }

}
