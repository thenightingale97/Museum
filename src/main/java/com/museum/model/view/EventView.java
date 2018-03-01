package com.museum.model.view;

import com.museum.entity.Event;
import org.apache.commons.lang3.time.DurationFormatUtils;

import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class EventView {

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm");

    private Integer id;

    private String name;

    private String guideFullName;

    private String startDate;

    private String startTime;

    private String finishTime;

    private String duration;

    private String imageUrl;

    private String description;

    public EventView(Event event) {
        this.id = event.getId();
        this.guideFullName = event.getGuide().getFirstName() + " " + event.getGuide().getLastName();
        this.name = event.getExcursion().getName();
        this.startDate = DATE_FORMATTER.format(event.getStartTime().toLocalDate());
        this.startTime = TIME_FORMATTER.format(event.getStartTime().toLocalTime());
        this.finishTime = TIME_FORMATTER.format(event.getFinishTime().toLocalTime());
        this.imageUrl = event.getExcursion().getImageUrl();
        this.description = event.getExcursion().getDescription();

        Duration duration = event.getExcursion().getDuration();
        if (duration != null) {
            this.duration = DurationFormatUtils.formatDuration(duration.toMillis(), "H:mm", true);
        } else {
            this.duration = "";
        }
    }

    public static List<EventView> ofAll(List<Event> events) {
        return events.stream().map(EventView::new).collect(Collectors.toList());
    }

    public static EventView of(Event event) {
        return new EventView(event);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getGuideFullName() {
        return guideFullName;
    }

    public void setGuideFullName(String guideFullName) {
        this.guideFullName = guideFullName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(String finishTime) {
        this.finishTime = finishTime;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
