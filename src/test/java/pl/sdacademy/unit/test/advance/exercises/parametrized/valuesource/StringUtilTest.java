package pl.sdacademy.unit.test.advance.exercises.parametrized.valuesource;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StringUtilTest {

    //true:
    // null, "", "   "
    //
    //false:
    // "sda", " sda", "sda ", " sda ", "null"
    //


    @ParameterizedTest
    @ValueSource(strings = {"", "   "})
    void shouldReturnTrueIfInputIsBlank(String value) {
        //when
        boolean result = StringUtil.isBlank(value);
        //then
        assertTrue(result); //junit
        assertThat(result).isTrue(); //assertJ
    }

    @ParameterizedTest
    @ValueSource(strings = {"sda", " sda", "sda ", " sda ", "null"})
    void shouldReturnFalseIfInputIsNotBlank(String value) {
        //when
        boolean result = StringUtil.isBlank(value);
        //then
        assertFalse(result); //junit
        assertThat(result).isFalse(); //assertJ
    }

    @Test
    void shouldReturnTrueIfInputIsNull(){
        //when
        boolean result = StringUtil.isBlank(null);
        //then
        assertTrue(result); //junit
        assertThat(result).isTrue(); //assertJ
    }

}