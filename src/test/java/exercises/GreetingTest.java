package exercises;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GreetingTest {

    private List<String> captureLines(Runnable action) {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        try {
            action.run();
        } finally {
            System.setOut(originalOut);
        }
        return outputStream.toString().strip().lines().toList();
    }

    @Test
    void greetsASingleVisitor() {
        assertEquals(
                List.of("Hello Alice, you are visitor number 1"),
                captureLines(() -> new Greeting().greet(new String[] { "Alice" })));
    }

    @Test
    void greetsTwoVisitorsInOrder() {
        assertEquals(
                List.of(
                        "Hello Alice, you are visitor number 1",
                        "Hello Bob, you are visitor number 2"),
                captureLines(() -> new Greeting().greet(new String[] { "Alice", "Bob" })));
    }

    @Test
    void greetsThreeVisitors() {
        assertEquals(
                List.of(
                        "Hello Ann, you are visitor number 1",
                        "Hello Ben, you are visitor number 2",
                        "Hello Cid, you are visitor number 3"),
                captureLines(() -> new Greeting().greet(new String[] { "Ann", "Ben", "Cid" })));
    }

    @Test
    void handlesAnEmptyVisitorList() {
        assertEquals(List.of(), captureLines(() -> new Greeting().greet(new String[] {})));
    }

    @Test
    void greetsRepeatedNamesWithIncreasingNumbers() {
        assertEquals(
                List.of(
                        "Hello Alice, you are visitor number 1",
                        "Hello Alice, you are visitor number 2"),
                captureLines(() -> new Greeting().greet(new String[] { "Alice", "Alice" })));
    }

    @Test
    void greetsASingleCharacterName() {
        assertEquals(
                List.of("Hello A, you are visitor number 1"),
                captureLines(() -> new Greeting().greet(new String[] { "A" })));
    }

    @Test
    void greetsANameContainingASpace() {
        assertEquals(
                List.of("Hello Mary Jane, you are visitor number 1"),
                captureLines(() -> new Greeting().greet(new String[] { "Mary Jane" })));
    }

    @Test
    void greetsFiveVisitors() {
        assertEquals(
                List.of(
                        "Hello A, you are visitor number 1",
                        "Hello B, you are visitor number 2",
                        "Hello C, you are visitor number 3",
                        "Hello D, you are visitor number 4",
                        "Hello E, you are visitor number 5"),
                captureLines(() -> new Greeting().greet(new String[] { "A", "B", "C", "D", "E" })));
    }

    @Test
    void greetsTenVisitorsWithCorrectNumbering() {
        String[] visitors = { "V1", "V2", "V3", "V4", "V5", "V6", "V7", "V8", "V9", "V10" };
        List<String> lines = captureLines(() -> new Greeting().greet(visitors));
        assertEquals(10, lines.size());
        assertEquals("Hello V1, you are visitor number 1", lines.get(0));
        assertEquals("Hello V10, you are visitor number 10", lines.get(9));
    }

    @Test
    void greetsFourVisitorsWithMixedNames() {
        assertEquals(
                List.of(
                        "Hello Zoe, you are visitor number 1",
                        "Hello Max, you are visitor number 2",
                        "Hello Eve, you are visitor number 3",
                        "Hello Sam, you are visitor number 4"),
                captureLines(() -> new Greeting().greet(new String[] { "Zoe", "Max", "Eve", "Sam" })));
    }
}
