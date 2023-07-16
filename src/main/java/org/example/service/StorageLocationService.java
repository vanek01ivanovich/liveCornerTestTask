package org.example.service;

import org.example.model.entity.AnimalType;
import org.example.model.entity.StorageLocation;

import java.util.List;

public interface StorageLocationService {

    StorageLocation getStorageLocationByName(String name);

    StorageLocation createStorageLocation(String name, AnimalType animalType);

    StorageLocation getStorageLocationByNameOrCreateIfEmpty(String name, AnimalType animalType);

    List<StorageLocation> getAllStorageLocation();

}
