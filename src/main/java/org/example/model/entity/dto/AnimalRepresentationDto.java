package org.example.model.entity.dto;

import lombok.*;
import org.example.model.entity.Animal;
import org.example.model.enums.EAnimalClass;


@ToString
@Getter
@Setter
@AllArgsConstructor
@Builder
public class AnimalRepresentationDto {

    private String animalName;

    private EAnimalClass animalClass;

    private String animalType;

    private String storageLocationName;

    public static AnimalRepresentationDto build(Animal animal){
        return AnimalRepresentationDto.builder()
                .animalName(animal.getName())
                .animalClass(animal.getAnimalClass().getName())
                .animalType(animal.getAnimalType().getName())
                .storageLocationName(animal.getStorageLocation().getName())
                .build();
    }

}
