package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.model.entity.AnimalType;
import org.example.persistence.repository.AnimalTypeRepository;
import org.example.service.AnimalTypeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class AnimalTypeServiceImpl implements AnimalTypeService {

    private final AnimalTypeRepository animalTypeRepository;

    @Override
    public AnimalType getAnimalTypeByName(String name) {
        return animalTypeRepository.findAnimalTypeByNameEqualsIgnoreCase(name)
                .orElse(null);
    }

    @Override
    public AnimalType createAnimalType(String name) {
        try {
            AnimalType build = AnimalType.builder()
                    .name(name)
                    .build();
            AnimalType animalType = animalTypeRepository.saveAndFlush(build);
            log.info("animalType {}", animalType);
            return animalType;
        } catch (Exception exception) {
            exception.printStackTrace();
            throw new RuntimeException("animalType wasn`t created");
        }
    }

    @Override
    public AnimalType getAnimalTypeByNameOrCreateIfEmpty(String name) {
        return animalTypeRepository.findAnimalTypeByNameEqualsIgnoreCase(name)
                .or(() -> Optional.of(createAnimalType(name)))
                .get();
    }

    @Override
    public List<AnimalType> getAllAnimalTypes() {
        return animalTypeRepository.findAll();
    }
}
