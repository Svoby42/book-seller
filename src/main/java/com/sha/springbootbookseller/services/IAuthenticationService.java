package com.sha.springbootbookseller.services;

import com.sha.springbootbookseller.entities.Person;

public interface IAuthenticationService {
    Person signInAndReturnJWT(Person signInRequest);
}
