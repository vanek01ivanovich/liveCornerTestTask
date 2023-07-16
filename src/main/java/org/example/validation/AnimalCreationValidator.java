package org.example.validation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.model.entity.AnimalType;
import org.example.model.entity.StorageLocation;
import org.example.model.entity.dto.AnimalCreateDto;
import org.example.service.AnimalTypeService;
import org.example.service.StorageLocationService;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Slf4j
@RequiredArgsConstructor
public class AnimalCreationValidator {

    private final AnimalTypeService animalTypeService;
    private final StorageLocationService storageLocationService;

    public boolean validateAnimalCreation(AnimalCreateDto animalCreateDto) {
        if (animalCreateDto.getAnimalName().equals("") || animalCreateDto.getAnimalClassName().equals("") ||
                animalCreateDto.getAnimalTypeName().equals("") || animalCreateDto.getStorageLocationName().equals("")){
            log.info("return false because some name is empty");
            return false;
        }

        Optional<AnimalType> animalType = Optional.ofNullable(animalTypeService.getAnimalTypeByName(animalCreateDto.getAnimalTypeName()));
        Optional<StorageLocation> storageLocation = Optional.ofNullable(storageLocationService.getStorageLocationByName(animalCreateDto.getStorageLocationName()));

        if (animalType.isPresent() && storageLocation.isPresent() &&
                !(animalType.get().getId().equals(storageLocation.get().getAnimalType().getId()))) {
            log.info("return false because animalType is present and storageLocation is present, but storage is not for such type");
            return false;
        } else if (!animalType.isPresent() && storageLocation.isPresent()) {
            log.info("return false because animalType is not present and storageLocation is present, but storage is not for such type");
            return false;
        }
        return true;
    }

}
