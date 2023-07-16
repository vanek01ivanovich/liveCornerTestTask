package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.model.entity.AnimalClass;
import org.example.model.enums.EAnimalClass;
import org.example.persistence.repository.AnimalClassRepository;
import org.example.service.AnimalClassService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnimalClassServiceImpl implements AnimalClassService {

    private final AnimalClassRepository animalClassRepository;

    @Override
    public AnimalClass getAnimalClassByName(String name) {
        return animalClassRepository.findAnimalClassByName(EAnimalClass.getRoleByName(name))
                .orElseThrow(() -> new RuntimeException("AnimalClass with name " + name + " is not found"));
    }

    @Override
    public List<AnimalClass> getAllAnimalClasses() {
        return animalClassRepository.findAll();
    }
}
