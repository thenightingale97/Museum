package com.museum.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "visitor")
public class Visitor extends IdentifiableEntity<Integer> {

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String login;

    @Column
    private String password;

    @Column
    private VisitorRole accessLevel;

    @ManyToMany(mappedBy = "visitors")
    private List<Event> events;

    public Visitor() {

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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public VisitorRole getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(VisitorRole accessLevel) {
        this.accessLevel = accessLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Visitor)) return false;
        if (!super.equals(o)) return false;

        Visitor visitor = (Visitor) o;

        if (firstName != null ? !firstName.equals(visitor.firstName) : visitor.firstName != null) return false;
        if (lastName != null ? !lastName.equals(visitor.lastName) : visitor.lastName != null) return false;
        if (login != null ? !login.equals(visitor.login) : visitor.login != null) return false;
        if (password != null ? !password.equals(visitor.password) : visitor.password != null) return false;
        if (accessLevel != visitor.accessLevel) return false;
        return events != null ? events.equals(visitor.events) : visitor.events == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (accessLevel != null ? accessLevel.hashCode() : 0);
        result = 31 * result + (events != null ? events.hashCode() : 0);
        return result;
    }
}
