package practice.datetimestamp;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeParsing {

    public LocalDateTime parseLocalDateTime(String dateTimeString) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy / HH:mm");
        return LocalDateTime.parse(dateTimeString, dateTimeFormatter);
    }

    public String reformatLocalDateTime(String dateTimeString) {
        LocalDateTime localDateTime = LocalDateTime.parse(dateTimeString, DateTimeFormatter.ofPattern("dd/MM/yyyy / HH:mm"));
        return localDateTime.format(DateTimeFormatter.ofPattern("dd-MM-yyyy' 'HH:mm"));
    }
}
