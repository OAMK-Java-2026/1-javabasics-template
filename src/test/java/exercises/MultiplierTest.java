package exercises;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MultiplierTest {

    private String captureOutput(Runnable action) {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        try {
            action.run();
        } finally {
            System.setOut(originalOut);
        }
        return outputStream.toString().trim();
    }

    @Test
    void multipliesTwoPositiveNumbers() {
        assertEquals("13", captureOutput(() -> new Multiplier().multiply(2, 3)));
    }

    @Test
    void multipliesWithZeroFirstArgument() {
        assertEquals("1", captureOutput(() -> new Multiplier().multiply(0, 5)));
    }

    @Test
    void multipliesWithZeroSecondArgument() {
        assertEquals("1", captureOutput(() -> new Multiplier().multiply(5, 0)));
    }

    @Test
    void multipliesWithBothZero() {
        assertEquals("1", captureOutput(() -> new Multiplier().multiply(0, 0)));
    }

    @Test
    void multipliesOnePositiveOneNegative() {
        assertEquals("-11", captureOutput(() -> new Multiplier().multiply(-2, 3)));
    }

    @Test
    void multipliesTwoNegativeNumbers() {
        assertEquals("13", captureOutput(() -> new Multiplier().multiply(-2, -3)));
    }

    @Test
    void multipliesTwoOnes() {
        assertEquals("3", captureOutput(() -> new Multiplier().multiply(1, 1)));
    }

    @Test
    void multipliesTwoTensDigitNumbers() {
        assertEquals("201", captureOutput(() -> new Multiplier().multiply(10, 10)));
    }

    @Test
    void multipliesTwoNegativeOnes() {
        assertEquals("3", captureOutput(() -> new Multiplier().multiply(-1, -1)));
    }

    @Test
    void multipliesOppositeSignNumbers() {
        assertEquals("-97", captureOutput(() -> new Multiplier().multiply(7, -7)));
    }
}
