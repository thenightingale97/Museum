package com.museum.model.request;

public class EventFilterRequest {

    private String excursionId;

    private String fromDateTime;

    private String toDateTime;

    public String getFromDateTime() {
        return fromDateTime;
    }

    public void setFromDateTime(String fromDateTime) {
        this.fromDateTime = fromDateTime;
    }

    public String getToDateTime() {
        return toDateTime;
    }

    public void setToDateTime(String toDateTime) {
        this.toDateTime = toDateTime;
    }

    public String getExcursionId() {
        return excursionId;
    }

    public void setExcursionId(String excursionId) {
        this.excursionId = excursionId;
    }
}
