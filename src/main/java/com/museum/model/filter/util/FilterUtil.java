package com.museum.model.filter.util;

import com.museum.entity.GuidePosition;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class FilterUtil {

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public static LocalDateTime parseDateTime(String dateTime) {
        if (dateTime == null) {
            return null;
        }
        try {
            return LocalDateTime.parse(dateTime, DATE_TIME_FORMATTER);
        } catch (DateTimeParseException ex) {
            return null;
        }
    }

    public static Integer parseInteger(String integer) {
        if (integer == null) {
            return null;
        }
        try {
            return Integer.valueOf(integer);
        } catch (NumberFormatException ex) {
            return null;
        }
    }

    public static GuidePosition parseGuidePosition(String position) {
        if (position == null) {
            return null;
        }
        try {
            return GuidePosition.valueOf(position);
        } catch (IllegalArgumentException ex) {
            return null;
        }
    }
}
