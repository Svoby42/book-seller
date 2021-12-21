package com.sha.springbootbookseller.security.jwt;

import com.sha.springbootbookseller.security.PersonPrincipal;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

public interface IJwtProvider {

    String generateToken(PersonPrincipal personPrincipal);
    Authentication getAuthentication(HttpServletRequest request);
    boolean validateToken(HttpServletRequest request);
}
