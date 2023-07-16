package org.example.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "animal_type")
public class AnimalType {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "animalType")
    @JsonIgnore
    private List<Animal> animals;

    @JsonIgnore
    @OneToMany(mappedBy = "animalType")
    private List<StorageLocation> storageLocation;

}
