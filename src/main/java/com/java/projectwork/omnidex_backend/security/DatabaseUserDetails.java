package com.java.projectwork.omnidex_backend.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.java.projectwork.omnidex_backend.model.Role;
import com.java.projectwork.omnidex_backend.model.User;

public class DatabaseUserDetails implements UserDetails {

    private final User user;
    private final Set<GrantedAuthority> authorities;

    public DatabaseUserDetails (User user){
        this.user = user;
        // Conversione ruoli di User in GrantedAuthority di Spring
        this.authorities = new HashSet<>();
        if (user.getRoles() != null){
            for(Role role : user.getRoles()){
                this.authorities.add(new SimpleGrantedAuthority(role.getName()));
            }
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public @Nullable String getPassword() {
        return user.getPassword();    
    }

    @Override
    public String getUsername() {
        return user.getUsername();        
    }

    public User getUser() {
        return user;
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
