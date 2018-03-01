package com.museum.entity;

import javax.persistence.*;
import java.time.Duration;
import java.util.List;

@Entity
@Table(name = "excursion")
public class Excursion extends IdentifiableEntity<Integer> {

    @Column
    private String name;

    @ManyToMany
    private List<Showpiece> showpieces;

    @OneToMany(mappedBy = "excursion")
    private List<Event> events;

    @Column
    private Duration duration;

    @Column
    private Integer maxVisitorAmount;

    @Column
    private String description;

    @Column
    private String imageUrl;
    public Excursion() {
    }

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

    public List<Showpiece> getShowpieces() {
        return showpieces;
    }

    public void setShowpieces(List<Showpiece> showpieces) {
        this.showpieces = showpieces;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Excursion)) return false;
        if (!super.equals(o)) return false;

        Excursion excursion = (Excursion) o;

        if (name != null ? !name.equals(excursion.name) : excursion.name != null) return false;
        if (showpieces != null ? !showpieces.equals(excursion.showpieces) : excursion.showpieces != null) return false;
        if (events != null ? !events.equals(excursion.events) : excursion.events != null) return false;
        if (duration != null ? !duration.equals(excursion.duration) : excursion.duration != null) return false;
        if (maxVisitorAmount != null ? !maxVisitorAmount.equals(excursion.maxVisitorAmount) : excursion.maxVisitorAmount != null)
            return false;
        return description != null ? description.equals(excursion.description) : excursion.description == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (showpieces != null ? showpieces.hashCode() : 0);
        result = 31 * result + (events != null ? events.hashCode() : 0);
        result = 31 * result + (duration != null ? duration.hashCode() : 0);
        result = 31 * result + (maxVisitorAmount != null ? maxVisitorAmount.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
