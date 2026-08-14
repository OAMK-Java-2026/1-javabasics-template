package exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FibonacciTest {

    @Test
    void firstElementIsZero() {
        assertEquals(0, new Fibonacci().getNumber(0));
    }

    @Test
    void secondElementIsOne() {
        assertEquals(1, new Fibonacci().getNumber(1));
    }

    @Test
    void thirdElementIsOne() {
        assertEquals(1, new Fibonacci().getNumber(2));
    }

    @Test
    void fourthElementIsTwo() {
        assertEquals(2, new Fibonacci().getNumber(3));
    }

    @Test
    void fifthElementIsThree() {
        assertEquals(3, new Fibonacci().getNumber(4));
    }

    @Test
    void sixthElementIsFive() {
        assertEquals(5, new Fibonacci().getNumber(5));
    }

    @Test
    void seventhElementIsEight() {
        assertEquals(8, new Fibonacci().getNumber(6));
    }

    @Test
    void eighthElementIsThirteen() {
        assertEquals(13, new Fibonacci().getNumber(7));
    }

    @Test
    void ninthElementIsTwentyOne() {
        assertEquals(21, new Fibonacci().getNumber(8));
    }

    @Test
    void tenthElementIsThirtyFour() {
        assertEquals(34, new Fibonacci().getNumber(9));
    }
}
