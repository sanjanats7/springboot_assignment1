package com.example.Springboot_assignment1.service;

import com.example.Springboot_assignment1.dto.financeDto;
import com.example.Springboot_assignment1.entity.Entity;
import com.example.Springboot_assignment1.repository.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class FinancetrackerService{

    private final EntryRepository entryRepository;

    @Autowired
    public FinancetrackerService(EntryRepository entryRepository) {
        this.entryRepository = entryRepository;
    }

    public Entity addEntry(financeDto entry) {
        Entity entry1 =  Entity.builder()
                .amount(entry.getAmount())
                .category(entry.getCategory())
                .date(entry.getDate())
                .description(entry.getDescription())
                .type(entry.getType())
                .build();
        return entryRepository.save(entry1);
    }

    public static List<Entity> getAllEntries() {
        return entryRepository.findAll();
    }

    public static Entry getById(Long Id){
        return entryRepository.findById(Id).orElse(null);
    }

    public static Optional<Entry> updateById(Long id, financeDto updateById) {
        return entryRepository.findById(id).map(entry -> {
            entry.setAmount(updateById.getAmount());
            entry.setCategory(updateById.getCategory());
            entry.setDate(updateById.getDate());
            entry.setDescription(updateById.getDescription());
            entry.setType(updateById.getType());
            return entryRepository.save(entry);
        });
    }

