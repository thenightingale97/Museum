package com.museum.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
	List<Event> events;
	
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
}
