package org.example.service.facade.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.model.entity.Animal;
import org.example.model.entity.AnimalClass;
import org.example.model.entity.AnimalType;
import org.example.model.entity.StorageLocation;
import org.example.model.entity.dto.AnimalCreateDto;
import org.example.service.AnimalClassService;
import org.example.service.AnimalService;
import org.example.service.AnimalTypeService;
import org.example.service.StorageLocationService;
import org.example.service.facade.DataEntryFacadeService;
import org.example.validation.AnimalCreationValidator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class DataEntryFacadeServiceImpl implements DataEntryFacadeService {

    private final AnimalService animalService;
    private final AnimalTypeService animalTypeService;
    private final AnimalClassService animalClassService;
    private final StorageLocationService storageLocationService;
    private final AnimalCreationValidator animalCreationValidator;

    @Override
    @Transactional
    public boolean createDataEntry(AnimalCreateDto animalCreateDto) {
        log.info("createDataEntry with animalCreateDto {}", animalCreateDto);

        if (!animalCreationValidator.validateAnimalCreation(animalCreateDto)) {
            return false;
        }

        AnimalType animalType = animalTypeService.getAnimalTypeByNameOrCreateIfEmpty(animalCreateDto.getAnimalTypeName());
        StorageLocation storageLocation = storageLocationService.getStorageLocationByNameOrCreateIfEmpty(animalCreateDto.getStorageLocationName(), animalType);
        AnimalClass animalClass = animalClassService.getAnimalClassByName(animalCreateDto.getAnimalClassName());

        return animalService.saveAnimal(Animal.builder()
                .name(animalCreateDto.getAnimalName())
                .animalClass(animalClass)
                .animalType(animalType)
                .storageLocation(storageLocation)
                .build());
    }
}
