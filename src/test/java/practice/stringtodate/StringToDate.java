package practice.stringtodate;

import java.time.*;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StringToDate {

	@Test
	public void givenDateString_ThenConvertToDate() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-ddHH:mm:ss.SSSz");
		ZonedDateTime localDateTime = ZonedDateTime.parse("2022-01-0112:00:00.000Z", formatter);
		log.info(""+ localDateTime.getDayOfMonth() +" "+ localDateTime.getDayOfWeek()+" "+ localDateTime.getDayOfYear()+" "+ localDateTime.getHour()+" "+ localDateTime.getMinute()+" "+ localDateTime.getYear());
	}
	
	@Test 
	public void givenDateString_ThenConvertToInstant() {
		String strDateTime = "2022-01-01T12:00:00.000Z";
		Instant instant = Instant.parse(strDateTime);
		log.info(""+instant.toEpochMilli());
		log.info("{}",instant.toEpochMilli()-System.currentTimeMillis());
	}

	@Test
	public void givenFileNameString_ThenParseMonthYear() {
		String fileName = "Dec2025_Billedstatements_7193_24-12-25_21-39.xls";
		String monthYearString = fileName.substring(0, 7);
		Assertions.assertEquals("Dec2025", monthYearString);
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MMMyyyy");
		YearMonth parsedYearMonth = YearMonth.parse(monthYearString, dateTimeFormatter);

		Assertions.assertEquals(Month.DECEMBER, parsedYearMonth.getMonth());
		Assertions.assertEquals(2025, parsedYearMonth.getYear());

	}
}
