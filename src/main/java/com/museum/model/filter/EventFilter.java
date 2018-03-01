package com.museum.model.filter;

import com.museum.model.filter.util.FilterUtil;
import com.museum.model.request.EventFilterRequest;

import java.time.LocalDateTime;

public class EventFilter {

    private final Integer excurtionId;

    private final LocalDateTime fromDateTime;

    private final LocalDateTime toDateTime;

    public EventFilter(Integer excurtionId, LocalDateTime fromDateTime, LocalDateTime toDateTime) {
        this.excurtionId = excurtionId;
        this.fromDateTime = fromDateTime;
        this.toDateTime = toDateTime;
    }

    public static EventFilter of(EventFilterRequest request) {
        return new EventFilter(
                FilterUtil.parseExcursionId(request.getExcursionId()),
                FilterUtil.parseDateTime(request.getFromDateTime()),
                FilterUtil.parseDateTime(request.getToDateTime()));
    }

    public Integer getExcurtionId() {
        return excurtionId;
    }

    public LocalDateTime getFromDateTime() {
        return fromDateTime;
    }

    public LocalDateTime getToDateTime() {
        return toDateTime;
    }

    public boolean hasExcursionId() {
        return excurtionId != null;
    }

    public boolean hasFromDateTime() {
        return fromDateTime != null;
    }

    public boolean hasToDateTime() {
        return toDateTime != null;
    }
}
