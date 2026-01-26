package practice.string;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

@Slf4j
public class StringManipulationTests {

    @Test
    public void givenString_thenSplitBySpace() {
        String s = "ROHIT AHUJA";
        String[] splitted = s.split(" ");
        log.info("splitted array - {}", Arrays.toString(splitted));
        log.info("splitted array length - {}", splitted.length);
        Assertions.assertEquals(0, Arrays.compare(new String[]{"ROHIT", "AHUJA"}, splitted));
    }

    @Test
    public void givenStringWithMultipleSpaces_thenSplitBySpace() {
        String s = "ROHIT  AHUJA";
        String[] splitted = s.split(" ");
        log.info("splitted array - {}", Arrays.toString(splitted));
        log.info("splitted array length - {}", splitted.length);
        Assertions.assertEquals(0, Arrays.compare(new String[]{"ROHIT", "", "AHUJA"}, splitted));
    }

    @Test
    public void givenStringWithMultiSpaces_thenSplitByWhitespace() {
        String s = "ROHIT  AHUJA";
        String[] splitted = s.split("\\s+");
        Assertions.assertEquals(0, Arrays.compare(new String[]{"ROHIT", "AHUJA"}, splitted));
    }

    @Test
    // in substring method, beginIndex is inclusive and endIndex is exclusive.
    public void givenString_thenWorkWithSubstring() {
        String s = "ROHIT  AHUJA";
        Assertions.assertEquals("ROHI", s.substring(0, 4));
    }

    @Test
    public void givenString_thenConvertIntoTitleCase() {
        String s = "ROHIT  AHUJA";
        String[] splitted = s.split("\\s+");
        String result = Arrays.stream(splitted)
                .filter(t -> !t.isEmpty())
                .map(String::toLowerCase)
                .map(t -> Character.toUpperCase(t.charAt(0)) + t.substring(1))
                .collect(Collectors.joining(" "));
        Assertions.assertEquals("Rohit Ahuja", result);

    }
}
