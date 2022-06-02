package pl.sdacademy.unit.test.advance.exercises.task1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @ParameterizedTest
    @MethodSource("dataProviderForMultiplyMethod")
    void shouldMultiplyTwoDigits(int firstDigit, int secondDigit, int expectedResult) {
        //when
        int result = Calculator.multiply(firstDigit, secondDigit);
        //then
        assertEquals(expectedResult, result); //junit
        assertThat(result).isEqualTo(expectedResult); //assertJ
    }

    private static Stream<Arguments> dataProviderForMultiplyMethod() {
        return Stream.of(
                Arguments.of(6, 2, 12),
                Arguments.of(8, 4, 32),
                Arguments.of(4, 2, 8)
        );
    }
}