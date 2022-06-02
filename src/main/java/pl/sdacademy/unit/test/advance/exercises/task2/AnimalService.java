package pl.sdacademy.unit.test.advance.exercises.task2;

public class AnimalService {
    private AnimalRepository animalRepository;

    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public Animal getById(long id) {
        return animalRepository
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("animal not exist with id: " + id));
    }

    public AnimalDto2 add(String name, String type) {
        AnimalDto animalDto = new AnimalDto(name, type);
        Animal animal = animalRepository.add(animalDto);
        return animalMapper(animal);
    }

    private AnimalDto2 animalMapper(Animal animal) {
        return new AnimalDto2(
                animal.getId(),
                animal.getType(),
                animal.getName(),
                true);
    }
}
