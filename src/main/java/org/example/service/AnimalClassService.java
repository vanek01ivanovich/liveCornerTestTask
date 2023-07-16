package org.example.service;

import org.example.model.entity.AnimalClass;
import org.example.model.entity.AnimalType;

import java.util.List;

public interface AnimalClassService {

    AnimalClass getAnimalClassByName(String name);

    List<AnimalClass> getAllAnimalClasses();

}
