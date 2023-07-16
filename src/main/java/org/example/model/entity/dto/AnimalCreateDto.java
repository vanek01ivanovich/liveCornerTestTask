package org.example.model.entity.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AnimalCreateDto {

    private String animalName;

    private String animalClassName;

    private String animalTypeName;

    private String storageLocationName;

}
