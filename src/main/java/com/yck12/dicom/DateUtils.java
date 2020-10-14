package com.yck12.dicom;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

@Slf4j
public final class DateUtils {
    private static DateTimeFormatter FORMATTER_DEFAULT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static DateTimeFormatter FORMATTER_DATE = DateTimeFormatter.ofPattern("yyyyMMdd");
    private static SimpleDateFormat FORMAT_DATE = new SimpleDateFormat("yyyyMMdd");

    private DateUtils() {
    }

    public static String formatFull(Date date) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
        return FORMATTER_DEFAULT.format(localDateTime);
    }

    public static String formatFull(LocalDateTime localDateTime) {
        return FORMATTER_DEFAULT.format(localDateTime);
    }

    public static String formatDate(LocalDateTime localDateTime) {
        return FORMATTER_DATE.format(localDateTime);
    }

    public static Date parseDate(String strDate) {
        try {
            return FORMAT_DATE.parse(strDate);
        } catch (ParseException var2) {
            log.error("parse {} error: {}", strDate, var2.getMessage());
            return null;
        }
    }

    public static String formatDcmDate(String dateStr) {
        if (StringUtils.isEmpty(dateStr)) {
            return null;
        } else {
            return dateStr.length() >= 8 ? dateStr.substring(0, 4) + "-" + dateStr.substring(4, 6) + "-" + dateStr.substring(6, 8) : dateStr;
        }
    }

    public static String formatDcmTime(String timeStr) {
        if (StringUtils.isEmpty(timeStr)) {
            return null;
        } else {
            return timeStr.length() >= 6 ? timeStr.substring(0, 2) + ":" + timeStr.substring(2, 4) + ":" + timeStr.substring(4, 6) : timeStr;
        }
    }

    public static Date plusDate(Date date, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        calendar.add(6, day);
        return calendar.getTime();
    }
}

