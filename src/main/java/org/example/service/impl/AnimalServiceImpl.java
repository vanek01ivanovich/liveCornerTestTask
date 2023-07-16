package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.model.entity.Animal;
import org.example.model.entity.dto.AnimalRepresentationDto;
import org.example.persistence.repository.AnimalRepository;
import org.example.service.AnimalService;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class AnimalServiceImpl implements AnimalService {

    private final AnimalRepository animalRepository;

    @Override
    public boolean saveAnimal(Animal animal) {
        log.info("saveAnimal started with animal {}", animal.toString());
        try {
            Animal createdAnimal = animalRepository.save(animal);
            log.info("saveAnimal performed createdAnimal {}", createdAnimal);
        } catch (Exception e) {
            log.error("error occurred {}", e.getMessage(), e);
            return false;
        }
        return true;
    }

    @Override
    public List<AnimalRepresentationDto> getAllAnimals(int page, int size) {
        return animalRepository.findAll(PageRequest.of(page, size))
                .getContent()
                .stream()
                .map(AnimalRepresentationDto::build)
                .collect(Collectors.toList());
    }

    @Override
    public List<AnimalRepresentationDto> getAllAnimals() {
        return animalRepository.findAllAnimals();
    }
}
