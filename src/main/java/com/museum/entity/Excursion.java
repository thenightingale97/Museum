package com.museum.entity;

import javax.persistence.*;
import java.time.Duration;
import java.util.List;

@Entity
@Table(name="excursion")
public class Excursion {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column
	private String name;
	
	@ManyToMany
	private List<Showpiece> showpieces;
	
	@OneToMany(mappedBy="excursion")
    private List<Event> events;
    
    @Column
    private Duration duration;
    
    @Column
    private Integer maxVisitorAmount;
    
    public Excursion() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
}
