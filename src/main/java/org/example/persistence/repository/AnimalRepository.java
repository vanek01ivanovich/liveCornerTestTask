package org.example.persistence.repository;

import org.example.model.entity.Animal;
import org.example.model.entity.dto.AnimalRepresentationDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, UUID> {

    @Query(value = "select new org.example.model.entity.dto.AnimalRepresentationDto(" +
            "a.name, ac.name, at.name, sl.name)" +
            "from Animal a " +
            "inner join AnimalClass ac on ac.id = a.animalClass.id " +
            "inner join AnimalType at on at.id = a.animalType.id " +
            "inner join StorageLocation sl on sl.id = a.storageLocation.id ")
    List<AnimalRepresentationDto> findAllAnimals();
}
