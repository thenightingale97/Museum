package com.museum.model.request;

public class ExcursionRequest {

    private Integer id;

    private String name;

    private Integer duration;

    private Integer maxVisitorAmount;

    private String description;

    private String imageUrl;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getMaxVisitorAmount() {
        return maxVisitorAmount;
    }

    public void setMaxVisitorAmount(Integer maxVisitorAmount) {
        this.maxVisitorAmount = maxVisitorAmount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
