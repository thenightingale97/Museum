package com.museum.service.impl.util;

import java.time.LocalDateTime;
import java.util.Objects;

public class Validations {
    
    public static void period(LocalDateTime fromTime, LocalDateTime toTime) {
        Objects.requireNonNull(fromTime, "fromTime");
        Objects.requireNonNull(toTime, "toTime");
        if (fromTime.isAfter(toTime)) {
            throw new IllegalArgumentException(
                    "Parameter 'fromTime' can`t be greater than 'toTime'.");
        }
    }
}
