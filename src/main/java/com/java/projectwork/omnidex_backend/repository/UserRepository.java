package com.java.projectwork.omnidex_backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.projectwork.omnidex_backend.model.User;

public interface UserRepository extends JpaRepository <User, Integer> {
    Optional<User> findByUsername(String username);
}
