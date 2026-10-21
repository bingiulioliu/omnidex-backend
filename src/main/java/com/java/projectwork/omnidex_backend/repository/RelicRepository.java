package com.java.projectwork.omnidex_backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.projectwork.omnidex_backend.model.Relic;

public interface RelicRepository extends JpaRepository<Relic, Integer> {
    public List<Relic> findByNameContainingIgnoringCase(String name);
    boolean existsByNameIgnoreCase(String name);
}
