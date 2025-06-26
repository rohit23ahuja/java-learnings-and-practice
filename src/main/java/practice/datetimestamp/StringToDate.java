package practice.datetimestamp;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class StringToDate {
    public static void main(String[] args) throws ParseException  {
        java.sql.Date dateParsed = StringToDate.getDate("Mon Sep 09 00:00:00 IST 2024");
        //java.sql.Date dateParsed = StringToDate.getDate("Wed Dec 04 00:00:00 IST 2024");
    }

    private static java.sql.Date getDate(String data) throws ParseException {
        String format = "E MMM dd HH:mm:ss Z yyyy";
        final DateFormat df = new SimpleDateFormat(format);
        final long time = df.parse(data).getTime();
        final java.sql.Date sqlDate1 = new java.sql.Date(time);
        return sqlDate1;
    }
}
