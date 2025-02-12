package com.example.Springboot_assignment1.repository;

import com.example.Springboot_assignment1.entity.Entity;
import com.example.Springboot_assignment1.entity.Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntryRepository extends JpaRepository<Entity, Long> {
}
