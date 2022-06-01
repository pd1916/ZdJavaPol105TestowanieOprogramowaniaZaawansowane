package pl.sdacademy.unit.test.advance.exercises.parametrized.csvsource;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PalindromeCheckerTest {
    //na potrzeby dydaktyczne mamy jeden wspólny test,
    //natomiast powinniśmy mieć dwa oddzielne pod true oraz false
    @ParameterizedTest
    @CsvSource({"Kamil Slimak, true",
                "kajak, TrUe",
                "sedes, TRUE",
                "kobyla ma maly bok, true",
                "java, false",
                "programowanie, false"})
    void shouldVerifyIfStringIsPalindrome(String input, boolean expectedResult){
        //when
        boolean result = PalindromeChecker.isPalindrome(input);
        //then
        assertEquals(expectedResult, result); //junit
        assertThat(result).isEqualTo(expectedResult); //assertJ
    }

}