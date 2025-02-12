package com.example.Springboot_assignment1.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "entries")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double amount;
    private String category;
    private LocalDate date;
    private String description;
    private String type;

}