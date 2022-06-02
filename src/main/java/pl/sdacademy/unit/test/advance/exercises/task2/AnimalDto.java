package pl.sdacademy.unit.test.advance.exercises.task2;

import java.util.Objects;

public class AnimalDto {
    private final String name;
    private final String type;

    public AnimalDto(String name, String type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        AnimalDto animalDto = (AnimalDto) o;
        return Objects.equals(name, animalDto.name) && Objects.equals(type, animalDto.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type);
    }
}
