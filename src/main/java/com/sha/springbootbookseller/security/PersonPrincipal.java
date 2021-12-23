package com.sha.springbootbookseller.security;

import com.sha.springbootbookseller.entities.Person;
import com.sha.springbootbookseller.entities.Role;
import com.sha.springbootbookseller.util.SecurityUtils;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.nio.file.attribute.UserPrincipal;
import java.util.Collection;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonPrincipal implements UserDetails {

    private Long id;
    private String username;
    transient private String password;
    transient private Person person;
    private Set<GrantedAuthority> authoritySet;

    public static PersonPrincipal createSuperUser(){
        Set<GrantedAuthority> authorities = Set.of(SecurityUtils.convertToAuthority(Role.SYSTEM_MANAGER.name()));

        return PersonPrincipal.builder()
                .id(-1L)
                .username("system-administrator")
                .authoritySet(authorities)
                .build();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authoritySet;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
