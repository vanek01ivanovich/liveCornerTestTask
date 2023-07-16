package org.example.persistence.repository;

import org.example.model.entity.StorageLocation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface StorageLocationRepository extends JpaRepository<StorageLocation, UUID> {

    Optional<StorageLocation> findStorageLocationByNameEqualsIgnoreCase(String name);

}
