package com.museum.model.filter;

import com.museum.model.request.EventFilterRequest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class EventFilter {

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    private final Integer id;

    private final LocalDateTime fromDateTime;

    private final LocalDateTime toDateTime;

    public EventFilter(Integer id, LocalDateTime fromDateTime, LocalDateTime toDateTime) {
        this.id = id;
        this.fromDateTime = fromDateTime;
        this.toDateTime = toDateTime;
    }

    public static EventFilter of(EventFilterRequest request) {
        return new EventFilter(
                parseExcursionId(request.getExcursionId()),
                parseDateTime(request.getFromDateTime()),
                parseDateTime(request.getToDateTime()));
    }

    private static LocalDateTime parseDateTime(String dateTime) {
        if (dateTime == null) {
            return null;
        }
        try {
            return LocalDateTime.parse(dateTime, DATE_TIME_FORMATTER);
        } catch (DateTimeParseException ex) {
            return null;
        }
    }

    private static Integer parseExcursionId(String excursionId) {
        if (excursionId == null) {
            return null;
        }
        try {
            return Integer.valueOf(excursionId);
        } catch (NumberFormatException ex) {
            return null;
        }
    }

    public Integer getId() {
        return id;
    }

    public LocalDateTime getFromDateTime() {
        return fromDateTime;
    }

    public LocalDateTime getToDateTime() {
        return toDateTime;
    }
}
