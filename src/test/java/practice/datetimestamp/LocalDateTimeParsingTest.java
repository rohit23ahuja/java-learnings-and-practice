package practice.datetimestamp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class LocalDateTimeParsingTest {

    @Test
    public void givenValidDateTimeString_thenParseLocalDateTime() {
        LocalDateTimeParsing localDateTimeParsing = new LocalDateTimeParsing();
        LocalDateTime localDateTime = localDateTimeParsing.parseLocalDateTime("22/11/2025 / 12:44");
        Assertions.assertEquals("2025-11-22T12:44", localDateTime.toString());
    }

    @Test
    public void givenValidDateTimeString_thenReformatLocalDateTime() {
        LocalDateTimeParsing localDateTimeParsing = new LocalDateTimeParsing();
        String reformatted = localDateTimeParsing.reformatLocalDateTime("22/11/2025 / 12:44");
        Assertions.assertEquals("22-11-2025 12:44", reformatted);
    }
}
