package org.example.model.enums;

import java.util.Arrays;

public enum EAnimalClass {
    MAMMAL("MAMMAL"),
    AMPHIBIAN("AMPHIBIAN"),
    WATERFOWL("WATERFOWL");

    private final String name;

    public String getName() {
        return name;
    }

    EAnimalClass(String name) {
        this.name = name;
    }

    public static EAnimalClass getRoleByName(String name) {
        return Arrays.stream(EAnimalClass.values())
                .filter(value -> value.name.equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("AnimalClass with value " + name + " is not found"));
    }

}
