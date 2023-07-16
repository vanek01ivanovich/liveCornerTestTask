package org.example.persistence.repository;

import org.example.model.entity.AnimalClass;
import org.example.model.entity.StorageLocation;
import org.example.model.enums.EAnimalClass;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface AnimalClassRepository extends JpaRepository<AnimalClass, UUID> {

    Optional<AnimalClass> findAnimalClassByName(EAnimalClass name);

}
