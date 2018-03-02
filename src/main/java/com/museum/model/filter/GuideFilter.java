package com.museum.model.filter;

import com.museum.entity.GuidePosition;
import com.museum.model.filter.util.FilterUtil;
import com.museum.model.request.GuideFilterRequest;

import java.time.LocalDateTime;

public class GuideFilter {

    private final String firstName;

    private final String lastName;

    private final GuidePosition position;

    private final Boolean busy;

    private final LocalDateTime fromDateTime;

    private final LocalDateTime toDateTime;

    public GuideFilter(String firstName, String lastName, GuidePosition position,
                       Boolean busy, LocalDateTime fromDateTime, LocalDateTime toDateTime) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.busy = busy;
        this.fromDateTime = fromDateTime;
        this.toDateTime = toDateTime;
    }

    public static GuideFilter of(GuideFilterRequest request) {
        return new GuideFilter(
                request.getFirstName(),
                request.getLastName(),
                FilterUtil.parseGuidePosition(request.getPosition()),
                FilterUtil.parseBoolean(request.getBusy()),
                FilterUtil.parseDateTime(request.getFromDateTime()),
                FilterUtil.parseDateTime(request.getToDateTime()));
    }

    public Boolean getBusy() {
        return busy;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public GuidePosition getPosition() {
        return position;
    }

    public LocalDateTime getFromDateTime() {
        return fromDateTime;
    }

    public LocalDateTime getToDateTime() {
        return toDateTime;
    }

    public boolean hasFromDateTime() {
        return fromDateTime != null;
    }

    public boolean hasToDateTime() {
        return toDateTime != null;
    }

    public boolean hasFromOrToDateTime() {
        return hasFromDateTime() || hasToDateTime();
    }

    public boolean hasPosition() {
        return position != null;
    }

    public boolean hasFirstName() {
        return firstName != null;
    }

    public boolean hasLastName() {
        return lastName != null;
    }

    public boolean hasBusy() {
        return busy != null;
    }
}
