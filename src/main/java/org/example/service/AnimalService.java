package org.example.service;

import org.example.model.entity.Animal;
import org.example.model.entity.dto.AnimalCreateDto;
import org.example.model.entity.dto.AnimalRepresentationDto;

import java.util.List;

public interface AnimalService {

    boolean saveAnimal(Animal animal);

    List<AnimalRepresentationDto> getAllAnimals(int page, int size);

    List<AnimalRepresentationDto> getAllAnimals();

}
