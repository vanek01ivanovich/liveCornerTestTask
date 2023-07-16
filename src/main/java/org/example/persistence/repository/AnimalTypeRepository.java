package org.example.persistence.repository;

import org.example.model.entity.AnimalType;
import org.example.model.entity.StorageLocation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface AnimalTypeRepository extends JpaRepository<AnimalType, UUID> {

    Optional<AnimalType> findAnimalTypeByNameEqualsIgnoreCase(String name);

}
