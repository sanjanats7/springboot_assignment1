package com.example.Springboot_assignment1.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class financeDto {
    Double amount;
    String category;
    LocalDate date;
    String description;
    String type;
}