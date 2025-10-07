package com.demo.base.util;

import lombok.experimental.UtilityClass;

import java.time.*;
import java.time.format.DateTimeFormatter;

@UtilityClass
public class DateTimeUtil {
    public ZonedDateTime convertFormulaToLocalDate(String formula) {
        LocalDate today = LocalDate.now();
        String[] parts = formula.split("-");
        String days = parts[1].substring(0, parts[1].length() - 1);
        Period period = Period.ofDays(Integer.parseInt(days));
        LocalDate date = today.minus(period);
        ZoneId zoneId = ZoneId.systemDefault();
        return date.atStartOfDay(zoneId);
    }

    public String toTimeStamp(LocalDateTime time){
        return String.valueOf(time.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
    }

    public LocalDateTime toLocalDateTime(String timestamp){
        long timestampUnix = Long.parseLong(timestamp);
        Instant instant = Instant.ofEpochSecond(timestampUnix);
        return LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
    }
    public LocalDateTime toLocalDateTimeZero(String timestamp){
        long timestampUnix = Long.parseLong(timestamp);
        Instant instant = Instant.ofEpochSecond(timestampUnix);
       return LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).with(LocalTime.MIDNIGHT);

    }
}
