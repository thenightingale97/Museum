package com.museum.model.request;

public class EventRequest {

    private Integer id;

    private Integer excursion;

    private Integer guide;

    private String startTime;

    private String finishTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getExcursion() {
        return excursion;
    }

    public void setExcursion(Integer excursion) {
        this.excursion = excursion;
    }

    public Integer getGuide() {
        return guide;
    }

    public void setGuide(Integer guide) {
        this.guide = guide;
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
}
