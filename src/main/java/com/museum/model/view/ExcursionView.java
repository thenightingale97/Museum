package com.museum.model.view;

import com.museum.entity.Excursion;
import org.apache.commons.lang3.time.DurationFormatUtils;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class ExcursionView {

    private static final String DURATION_FORMAT_PATTERN = "H:mm";

    private Integer id;

    private String name;

    private String description;

    private String duration;

    private String maxVisitorAmount;

    private String imageUrl;

    public ExcursionView(Excursion excursion) {
        this.id = excursion.getId();
        this.name = excursion.getName();
        this.imageUrl = excursion.getImageUrl();
        this.description = excursion.getDescription();
        this.duration = formatDuration(excursion.getDuration());
        this.maxVisitorAmount = formatMaxVisitorAmount(excursion.getMaxVisitorAmount());
    }

    private static String formatDuration(Duration duration) {
        return duration != null
                ? DurationFormatUtils.formatDuration(duration.toMillis(), DURATION_FORMAT_PATTERN, true)
                : null;
    }

    private static String formatMaxVisitorAmount(Integer maxVisitorAmount) {
        return maxVisitorAmount != null
                ? maxVisitorAmount.toString()
                : null;
    }

    public static List<ExcursionView> ofAll(List<Excursion> excursions) {
        return excursions.stream().map(ExcursionView::new).collect(Collectors.toList());
    }

    public static ExcursionView of(Excursion excursion) {
        return new ExcursionView(excursion);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getMaxVisitorAmount() {
        return maxVisitorAmount;
    }

    public void setMaxVisitorAmount(String maxVisitorAmount) {
        this.maxVisitorAmount = maxVisitorAmount;
    }
}
