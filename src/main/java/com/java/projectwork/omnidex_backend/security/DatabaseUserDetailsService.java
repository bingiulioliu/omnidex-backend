package com.java.projectwork.omnidex_backend.security;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.java.projectwork.omnidex_backend.model.User;
import com.java.projectwork.omnidex_backend.repository.UserRepository;

@Service 
public class DatabaseUserDetailsService implements UserDetailsService {
    
    private final UserRepository userRepository;

    public DatabaseUserDetailsService (UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override 
    public UserDetails loadUserByUsername (String username) throws UsernameNotFoundException{
        Optional<User> userAttempt = userRepository.findByUsername(username);

        if (userAttempt.isEmpty()){
            throw new UsernameNotFoundException("Non è stato trovato l'utente con username: " + username);
        }
        return new DatabaseUserDetails(userAttempt.get());
    }
}
