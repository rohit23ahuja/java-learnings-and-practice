package com.java.practice.datetimestamp;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimestampAndInstantPractice {
	public static void main(String[] args) {
		// "2022-10-14T14:45:15.455+0000"
		String dateTimeString = "2022-10-23T08:30:02.000Z";
		log.info("plain input timestamp string - {}", dateTimeString);
		Instant instant = Instant.parse(dateTimeString);
		Timestamp timestamp = Timestamp.from(instant);

		// plain timestamp
		log.info("Plain Timestamp - {}", timestamp);

		// formatted timestamp
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
		df.setTimeZone(TimeZone.getTimeZone("UTC"));
		log.info("Formatted Timestamp - {}", df.format(timestamp));

		Instant instant2 = timestamp.toInstant();
		log.info("Instant - {}", instant2);

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
		formatter = formatter.withZone(TimeZone.getTimeZone("UTC").toZoneId());
		log.info("Formatted Instant - {}", formatter.format(instant2));
	}
}
