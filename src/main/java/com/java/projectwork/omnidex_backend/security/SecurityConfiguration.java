package com.java.projectwork.omnidex_backend.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
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
                .requestMatchers(HttpMethod.GET,"/api/relics", "/api/relics/**").permitAll()
                .anyRequest().authenticated()
            );
            
        return http.build();
    }

    // Catena per la view (Thymeleaf), Order 2
    @Bean 
    @Order (2)
    public SecurityFilterChain webSecurityFilterChain(HttpSecurity http) throws Exception{
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/login", "/error", "/css/**", "/js/**", "/webjars/**").permitAll()
                // Accesso solo ADMIN
                .requestMatchers(HttpMethod.POST, "/relics/**", "/categories/**", "/universes/**").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.DELETE, "/relics/**", "/categories/**", "/universes/**").hasAuthority("ADMIN")
                .requestMatchers("/relics/create-or-edit", "/categories/create-or-edit", "/universes/create-or-edit").hasAuthority("ADMIN")
                // Lettura sia Admin che User
                .requestMatchers(HttpMethod.GET, "/", "/index", "/relics/**", "/categories/**", "/universes/**").hasAnyAuthority("ADMIN", "USER")
                // Qualsiasi altra pagina
                .anyRequest().authenticated()
            )   
            // Form di login per la view
            .formLogin(form -> form.defaultSuccessUrl("/", true))
            // Logout
            .logout(logout -> logout.logoutSuccessUrl("/login"))
            .exceptionHandling(Customizer.withDefaults());
        return http.build();
    }

    @Bean 
    PasswordEncoder passwordEncoder(){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
