package com.museum.model.filter;

import com.museum.entity.GuidePosition;
import com.museum.model.filter.util.FilterUtil;
import com.museum.model.request.GuideFilterRequest;

import java.time.LocalDateTime;

public class GuideFilter {

    private final String firstName;

    private final String lastName;

    private final GuidePosition position;

    private final LocalDateTime freeFromDateTime;

    private final LocalDateTime freeToDateTime;

    public GuideFilter(String firstName, String lastName, GuidePosition position,
                       LocalDateTime freeFromDateTime, LocalDateTime freeToDateTime) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.freeFromDateTime = freeFromDateTime;
        this.freeToDateTime = freeToDateTime;
    }

    public static GuideFilter of(GuideFilterRequest request) {
        return new GuideFilter(
                request.getFirstName(),
                request.getLastName(),
                FilterUtil.parseGuidePosition(request.getPosition()),
                FilterUtil.parseDateTime(request.getFreeFromDateTime()),
                FilterUtil.parseDateTime(request.getFreeToDateTime()));
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

    public LocalDateTime getFreeFromDateTime() {
        return freeFromDateTime;
    }

    public LocalDateTime getFreeToDateTime() {
        return freeToDateTime;
    }

    public boolean hasFreeFromDateTime() {
        return freeFromDateTime != null;
    }

    public boolean hasFreeToDateTime() {
        return freeToDateTime != null;
    }

    public boolean hasFreeFromOrToDateTime() {
        return hasFreeFromDateTime() || hasFreeToDateTime();
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
}
