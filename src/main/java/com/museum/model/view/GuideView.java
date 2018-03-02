package com.museum.model.view;

import com.museum.entity.Guide;
import com.museum.model.statistic.GuideStatistic;
import com.museum.model.view.util.ViewUtil;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class GuideView {

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private String position;

    private String eventCount;

    private String workDuration;

    public GuideView(Guide guide) {
        this(guide, null, null);
    }

    public GuideView(GuideStatistic guideStatistic) {
        this(guideStatistic.getGuide(), guideStatistic.getEventCount(), guideStatistic.getWorkDuration());
    }

    public GuideView(Guide guide, Long eventCount, Duration workDuration) {
        this.firstName = guide.getFirstName();
        this.lastName = guide.getLastName();
        this.phoneNumber = guide.getPhoneNumber();
        this.position = ViewUtil.formatGuidePosition(guide.getPosition());
        this.eventCount = ViewUtil.formatLong(eventCount);
        this.workDuration = ViewUtil.formatDuration(workDuration);
    }

    public static List<GuideView> listOf(List<Guide> guides) {
        return guides.stream().map(GuideView::new).collect(Collectors.toList());
    }

    public static List<GuideView> listOfStatistics(List<GuideStatistic> guideStatistics) {
        return guideStatistics.stream().map(GuideView::new).collect(Collectors.toList());
    }

    public static GuideView of(Guide guide) {
        return new GuideView(guide);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEventCount() {
        return eventCount;
    }

    public void setEventCount(String eventCount) {
        this.eventCount = eventCount;
    }

    public String getWorkDuration() {
        return workDuration;
    }

    public void setWorkDuration(String workDuration) {
        this.workDuration = workDuration;
    }
}
