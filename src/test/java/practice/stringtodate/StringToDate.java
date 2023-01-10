package practice.stringtodate;

import java.time.Instant;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

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
}
