package com.sha.springbootbookseller.services;

import com.sha.springbootbookseller.entities.Person;
import com.sha.springbootbookseller.security.PersonPrincipal;
import com.sha.springbootbookseller.security.jwt.IJwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService implements IAuthenticationService{

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private IJwtProvider jwtProvider;

    @Override
    public Person signInAndReturnJWT(Person signInRequest){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signInRequest.getUsername(), signInRequest.getPassword())
        );

        PersonPrincipal personPrincipal = (PersonPrincipal) authentication.getPrincipal();
        String jwt = jwtProvider.generateToken(personPrincipal);

        Person signInUser = personPrincipal.getPerson();
        signInUser.setToken(jwt);

        return signInUser;
    }

}
