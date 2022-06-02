package pl.sdacademy.unit.test.advance.exercises.task2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AnimalServiceTest {
    private static final Animal ANIMAL = new Animal(1L, "mammal", "dog");
    private static final AnimalDto ANIMAL_DTO = new AnimalDto("dog", "mammal");
    private static final AnimalDto2 ANIMAL_DTO_2 = new AnimalDto2(1l, "mammal", "dog", true);

    @Mock
    private AnimalRepository animalRepository;

    @InjectMocks
    private AnimalService animalService;

    @Test
    void shouldReturnAnimalById() {
        //given
        when(animalRepository.findById(anyLong())).thenReturn(Optional.of(ANIMAL));
        //when
        Animal result = animalService.getById(1L);
        //then
        assertEquals(ANIMAL, result); //junit
        assertThat(result).isEqualTo(ANIMAL); //assertJ
    }

    @Test
    void shouldThrowExceptionWhenAnimalNotExist() {
        //given
        when(animalRepository.findById(anyLong())).thenReturn(Optional.empty());
        //when & then
        //junit
        assertThrows(IllegalArgumentException.class,
                () -> animalService.getById(1L));
        //assertJ
        assertThatThrownBy(() -> animalService.getById(1L))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("animal not exist with id: 1");
    }

    @Test
    void shouldAddNewAnimal() {
        //given
        when(animalRepository.add(ANIMAL_DTO)).thenReturn(ANIMAL);
        //when
        AnimalDto2 result = animalService.add("dog", "mammal");
        //then
        assertEquals(ANIMAL_DTO_2, result); //junit
        assertThat(result).isEqualTo(ANIMAL_DTO_2); //assertJ
    }

}