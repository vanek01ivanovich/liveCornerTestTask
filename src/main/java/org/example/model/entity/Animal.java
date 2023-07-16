package org.example.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "animal")
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Animal {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "animal_class_id", referencedColumnName = "id")
    private AnimalClass animalClass;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "animal_type_id", referencedColumnName = "id")
    private AnimalType animalType;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "storage_location_id", referencedColumnName = "id")
    private StorageLocation storageLocation;
}
