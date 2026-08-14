package exercises;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CheckerTest {

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
    void printsPosForOne() {
        assertEquals("pos", captureOutput(() -> new Checker().checkNum(1)));
    }

    @Test
    void printsPosForLargePositiveNumber() {
        assertEquals("pos", captureOutput(() -> new Checker().checkNum(1000)));
    }

    @Test
    void printsNegForMinusOne() {
        assertEquals("neg", captureOutput(() -> new Checker().checkNum(-1)));
    }

    @Test
    void printsNegForLargeNegativeNumber() {
        assertEquals("neg", captureOutput(() -> new Checker().checkNum(-1000)));
    }

    @Test
    void printsZeroForZero() {
        assertEquals("zero", captureOutput(() -> new Checker().checkNum(0)));
    }

    @Test
    void printsPosForMaxInteger() {
        assertEquals("pos", captureOutput(() -> new Checker().checkNum(Integer.MAX_VALUE)));
    }

    @Test
    void printsNegForMinInteger() {
        assertEquals("neg", captureOutput(() -> new Checker().checkNum(Integer.MIN_VALUE)));
    }

    @Test
    void printsPosForFive() {
        assertEquals("pos", captureOutput(() -> new Checker().checkNum(5)));
    }

    @Test
    void printsNegForMinusFive() {
        assertEquals("neg", captureOutput(() -> new Checker().checkNum(-5)));
    }

    @Test
    void printsPosForSmallPositiveNumber() {
        assertEquals("pos", captureOutput(() -> new Checker().checkNum(3)));
    }
}
