package com.museum.model.view.util;

import com.museum.entity.GuidePosition;
import org.apache.commons.lang3.time.DurationFormatUtils;

import java.time.Duration;

public class ViewUtil {

    private static final String DURATION_FORMAT_PATTERN = "H:mm";

    public static String formatDuration(Duration duration) {
        return duration != null
                ? DurationFormatUtils.formatDuration(duration.toMillis(), DURATION_FORMAT_PATTERN, true)
                : null;
    }

    public static String formatLong(Long value) {
        return value != null ? value.toString() : null;
    }

    public static String formatGuidePosition(GuidePosition position) {
        return position != null ? position.toString() : null;
    }
}
