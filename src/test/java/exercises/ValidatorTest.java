package exercises;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ValidatorTest {

    private String captureOutput(Runnable action) {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        try {
            action.run();
        } finally {
            System.setOut(originalOut);
        }
        return outputStream.toString();
    }

    @Test
    void printsEvenNumbersUpToNine() {
        assertEquals("2,4,6,8", captureOutput(() -> new Validator().oddOut((short) 9)));
    }

    @Test
    void printsNothingWhenLimitIsOne() {
        assertEquals("", captureOutput(() -> new Validator().oddOut((short) 1)));
    }

    @Test
    void printsNothingWhenLimitIsTwo() {
        assertEquals("", captureOutput(() -> new Validator().oddOut((short) 2)));
    }

    @Test
    void printsFirstEvenNumberWhenLimitIsThree() {
        assertEquals("2", captureOutput(() -> new Validator().oddOut((short) 3)));
    }

    @Test
    void printsMessageWhenLimitIsZero() {
        assertEquals("No even numbers to print.", captureOutput(() -> new Validator().oddOut((short) 0)));
    }

    @Test
    void printsMessageWhenLimitIsNegative() {
        assertEquals("No even numbers to print.", captureOutput(() -> new Validator().oddOut((short) -5)));
    }

    @Test
    void printsEvenNumbersUpToTwenty() {
        assertEquals("2,4,6,8,10,12,14,16,18", captureOutput(() -> new Validator().oddOut((short) 20)));
    }

    @Test
    void printsEvenNumbersUpToFive() {
        assertEquals("2,4", captureOutput(() -> new Validator().oddOut((short) 5)));
    }

    @Test
    void printsEvenNumbersUpToFifteen() {
        assertEquals("2,4,6,8,10,12,14", captureOutput(() -> new Validator().oddOut((short) 15)));
    }

    @Test
    void printsEvenNumbersUpToSix() {
        assertEquals("2,4", captureOutput(() -> new Validator().oddOut((short) 6)));
    }
}
