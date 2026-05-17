package practice.string;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@Slf4j
public class StringFormatPractice {

    @Test
    public void givenArgumentsAndFormat_thenFormatString(){
        String format = """
                    Statement file id: %s exists for month year: %s and type: %s. Please send reProcess as true for processing again. Note - Existing transactions will be deleted in case of re-processing.
                    """;
        String outputFormattedString = String.format(format,
                Long.valueOf("1"),
                "Oct 1988",
                "Credit Card");
        String expectedFormattedString = """
                Statement file id: 1 exists for month year: Oct 1988 and type: Credit Card. Please send reProcess as true for processing again. Note - Existing transactions will be deleted in case of re-processing.
                """;
        Assertions.assertEquals(expectedFormattedString, outputFormattedString);
    }
}
