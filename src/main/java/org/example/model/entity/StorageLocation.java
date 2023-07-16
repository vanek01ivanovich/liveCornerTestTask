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
@Table(name = "storage_location")
public class StorageLocation {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "storageLocation")
    @JsonIgnore
    private List<Animal> animals;

    @JsonIgnore
    @JoinColumn(name = "animal_type_id", referencedColumnName = "id")
    @ManyToOne
    private AnimalType animalType;

}
