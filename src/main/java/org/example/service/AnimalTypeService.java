package org.example.service;

import org.example.model.entity.AnimalType;

import java.util.List;

public interface AnimalTypeService {

    AnimalType getAnimalTypeByName(String name);

    AnimalType createAnimalType(String name);

    AnimalType getAnimalTypeByNameOrCreateIfEmpty(String name);

    List<AnimalType> getAllAnimalTypes();

}
