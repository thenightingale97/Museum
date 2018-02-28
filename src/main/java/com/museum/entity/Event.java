package com.museum.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "event")
public class Event extends IdentifiableEntity<Integer> {

    @ManyToOne
    private Excursion excursion;

    @ManyToOne
    private Guide guide;

    @ManyToMany
    private List<Visitor> visitors;

    @Column
    private LocalDateTime startTime;

    @Column
    private LocalDateTime finishTime;

    public Event() {

    }

    public Excursion getExcursion() {
        return excursion;
    }

    public void setExcursion(Excursion excursion) {
        this.excursion = excursion;
    }

    public Guide getGuide() {
        return guide;
    }

    public void setGuide(Guide guide) {
        this.guide = guide;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(LocalDateTime finishTime) {
        this.finishTime = finishTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Event)) return false;
        if (!super.equals(o)) return false;

        Event event = (Event) o;

        if (excursion != null ? !excursion.equals(event.excursion) : event.excursion != null) return false;
        if (guide != null ? !guide.equals(event.guide) : event.guide != null) return false;
        if (visitors != null ? !visitors.equals(event.visitors) : event.visitors != null) return false;
        if (startTime != null ? !startTime.equals(event.startTime) : event.startTime != null) return false;
        return finishTime != null ? finishTime.equals(event.finishTime) : event.finishTime == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (excursion != null ? excursion.hashCode() : 0);
        result = 31 * result + (guide != null ? guide.hashCode() : 0);
        result = 31 * result + (visitors != null ? visitors.hashCode() : 0);
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        result = 31 * result + (finishTime != null ? finishTime.hashCode() : 0);
        return result;
    }
}
