package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.model.entity.AnimalType;
import org.example.model.entity.StorageLocation;
import org.example.persistence.repository.StorageLocationRepository;
import org.example.service.StorageLocationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StorageLocationServiceImpl implements StorageLocationService {

    private final StorageLocationRepository storageLocationRepository;

    @Override
    public StorageLocation getStorageLocationByName(String name) {
        return storageLocationRepository.findStorageLocationByNameEqualsIgnoreCase(name)
                .orElse(null);
    }

    @Override
    public StorageLocation createStorageLocation(String name, AnimalType animalType) {
        return storageLocationRepository.save(StorageLocation.builder()
                .name(name)
                .animalType(animalType)
                .build());
    }

    @Override
    public StorageLocation getStorageLocationByNameOrCreateIfEmpty(String name, AnimalType animalType) {
        return storageLocationRepository.findStorageLocationByNameEqualsIgnoreCase(name)
                .or(() -> Optional.of(createStorageLocation(name, animalType)))
                .get();
    }

    @Override
    public List<StorageLocation> getAllStorageLocation() {
        return storageLocationRepository.findAll();
    }
}
