package com.museum.model.view;

import com.museum.entity.Guide;

import java.util.List;
import java.util.stream.Collectors;

public class GuideView {

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private String position;

    public GuideView(Guide guide) {
        this.firstName = guide.getFirstName();
        this.lastName = guide.getLastName();
        this.phoneNumber = guide.getPhoneNumber();
        this.position = guide.getPosition().name();
    }

    public static List<GuideView> ofAll(List<Guide> events) {
        return events.stream().map(GuideView::new).collect(Collectors.toList());
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
}
