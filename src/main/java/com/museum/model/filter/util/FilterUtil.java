package com.museum.model.filter.util;

import com.museum.entity.GuidePosition;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class FilterUtil {

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public static Boolean parseBoolean(String value) {
        return parse(value, Boolean::valueOf, null);
    }

    public static LocalDateTime parseDateTime(String value) {
        return parse(value, v -> LocalDateTime.parse(v, DATE_TIME_FORMATTER), DateTimeParseException.class);
    }

    public static Integer parseInteger(String value) {
        return parse(value, Integer::valueOf, NumberFormatException.class);
    }

    public static GuidePosition parseGuidePosition(String value) {
        return parse(value, GuidePosition::valueOf, IllegalArgumentException.class);
    }

    private static <V, X extends RuntimeException> V parse(String value, Parser<V, X> parser, Class<X> exceptionClass) {
        if (value == null) {
            return null;
        }
        try {
            return parser.parse(value);
        } catch (RuntimeException ex) {
            if (exceptionClass != null && exceptionClass.isInstance(ex)) {
                return null;
            } else {
                throw ex;
            }
        }
    }

    @FunctionalInterface
    private interface Parser<V, X extends RuntimeException> {
        V parse(String value) throws X;
    }
}
