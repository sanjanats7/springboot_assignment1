package com.example.Springboot_assignment1.controller;

import com.example.Springboot_assignment1.dto.financeDto;
import com.example.Springboot_assignment1.entity.Entity;  // Corrected class import
import com.example.Springboot_assignment1.service.FinancetrackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/entries")
public class FinanceController {

    private final FinancetrackerService financetrackerService;

    @Autowired
    public FinanceController(FinancetrackerService financetrackerService) {
        this.financetrackerService = financetrackerService;
    }

    @PostMapping
    public ResponseEntity<Entity> createEntry(@RequestBody financeDto entry) {
        Entity savedEntry = financetrackerService.addEntry(entry);
        return ResponseEntity.ok(savedEntry);
    }

    @GetMapping
    public List<Entity> getAllEntries() {
        return financetrackerService.getAllEntries();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Entity> getById(@PathVariable Long id) {
        Optional<Entity> entry = FinancetrackerService.getById(id);
        return entry.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Entity> update(@PathVariable Long id, @RequestBody financeDto update) {
        Optional<Entity> updated = FinancetrackerService.updateById(id, update);
        return updated.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        boolean isDeleted = FinancetrackerService.deleteById(id);
        return isDeleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
