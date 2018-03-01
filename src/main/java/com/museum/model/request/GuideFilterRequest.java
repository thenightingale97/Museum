package com.museum.model.request;

public class GuideFilterRequest {

    private String firstName;

    private String lastName;

    private String position;

    private String freeFromDateTime;

    private String freeToDateTime;

    public String getFreeFromDateTime() {
        return freeFromDateTime;
    }

    public void setFreeFromDateTime(String freeFromDateTime) {
        this.freeFromDateTime = freeFromDateTime;
    }

    public String getFreeToDateTime() {
        return freeToDateTime;
    }

    public void setFreeToDateTime(String freeToDateTime) {
        this.freeToDateTime = freeToDateTime;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
