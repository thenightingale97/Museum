package com.museum.model.statistic;

import com.museum.entity.Guide;

import java.time.Duration;

public class GuideStatistic {

    private final Guide guide;

    private final Long eventCount;

    private final Duration workDuration;

    public GuideStatistic(Guide guide, Long eventCount, Duration workDuration) {
        this.guide = guide;
        this.eventCount = eventCount;
        this.workDuration = workDuration;
    }

    public GuideStatistic(Guide guide, Long eventCount, Long workDurationNanos) {
        this.guide = guide;
        this.eventCount = eventCount;
        this.workDuration = workDurationNanos != null ? Duration.ofNanos(workDurationNanos) : null;
    }

    public Guide getGuide() {
        return guide;
    }

    public Long getEventCount() {
        return eventCount;
    }

    public Duration getWorkDuration() {
        return workDuration;
    }
}
