package org.example.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.example.model.enums.EAnimalClass;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "animal_class")
public class AnimalClass {

    @Id
    @GeneratedValue
    private UUID id;

    @Enumerated(EnumType.STRING)
    @Column(name = "name")
    private EAnimalClass name;

    @OneToMany(mappedBy = "animalClass")
    @JsonIgnore
    private List<Animal> animals;


}
