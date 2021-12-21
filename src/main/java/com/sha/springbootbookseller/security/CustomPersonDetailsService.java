package com.sha.springbootbookseller.security;

import com.sha.springbootbookseller.entities.Person;
import com.sha.springbootbookseller.services.IPersonService;
import com.sha.springbootbookseller.util.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CustomPersonDetailsService implements UserDetailsService {

    @Autowired
    private IPersonService personService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Person person = personService.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));

        Set<GrantedAuthority> authoritySet = Set.of(SecurityUtils.convertToAuthority(person.getRole().name()));

        return PersonPrincipal.builder()
                .person(person).id(person.getId())
                .username(username)
                .password(person.getPassword())
                .authoritySet(authoritySet)
                .build();

    }
}
