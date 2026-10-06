package com.java.projectwork.omnidex_backend.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration 
@EnableWebSecurity 
public class SecurityConfiguration {

    // Filter chain per le API REST (React), Order 1
    @Bean 
    @Order (1)
    public SecurityFilterChain apiSecurituFilterChain(HttpSecurity http) throws Exception{
        http
            // Applico questa configurazione per le richieste che iniziano con /api
            .securityMatcher("/api/**")

            // Disabilito csrf per le API REST
            .csrf(csrf -> csrf.disable())

            // Autorizzazioni
            .authorizeHttpRequests(auth -> auth
                // Consento a tutti i guest l'accesso senza autorizzazione
                .requestMatchers(HttpMethod.GET, "/api/relics/**").permitAll()
                .anyRequest().authenticated()
            );
            
        return http.build();
    }
}
