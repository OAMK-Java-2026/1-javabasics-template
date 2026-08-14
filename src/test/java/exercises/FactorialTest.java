package exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FactorialTest {

    @Test
    void calculatesFactorialOfFive() {
        assertEquals(120L, new Factorial().factorial(5));
    }

    @Test
    void calculatesFactorialOfOne() {
        assertEquals(1L, new Factorial().factorial(1));
    }

    @Test
    void returnsMinusOneForZero() {
        assertEquals(-1L, new Factorial().factorial(0));
    }

    @Test
    void returnsMinusOneForNegativeNumber() {
        assertEquals(-1L, new Factorial().factorial(-3));
    }

    @Test
    void returnsMinusOneForNumberAboveTwenty() {
        assertEquals(-1L, new Factorial().factorial(21));
    }

    @Test
    void calculatesFactorialOfTwenty() {
        assertEquals(2432902008176640000L, new Factorial().factorial(20));
    }

    @Test
    void calculatesFactorialOfTen() {
        assertEquals(3628800L, new Factorial().factorial(10));
    }

    @Test
    void calculatesFactorialOfTwo() {
        assertEquals(2L, new Factorial().factorial(2));
    }

    @Test
    void calculatesFactorialOfSix() {
        assertEquals(720L, new Factorial().factorial(6));
    }

    @Test
    void returnsMinusOneForNumberFarAboveTwenty() {
        assertEquals(-1L, new Factorial().factorial(100));
    }
}
