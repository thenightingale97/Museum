package com.museum.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="hall")
public class Hall {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column
	private String name;
	
	@OneToMany(mappedBy="hall")
	private List<Showpiece> showpieces;
	
	@ManyToOne
	private Guardian guardian;
	
	public Hall() {
		
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
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		
		Hall hall = (Hall) o;
		
		if (id != hall.id) return false;
		if (name != null ? !name.equals(hall.name) : hall.name != null) return false;
		if (showpieces != null ? !showpieces.equals(hall.showpieces) : hall.showpieces != null) return false;
		return guardian != null ? guardian.equals(hall.guardian) : hall.guardian == null;
	}
	
	@Override
	public int hashCode() {
		int result = id;
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + (showpieces != null ? showpieces.hashCode() : 0);
		result = 31 * result + (guardian != null ? guardian.hashCode() : 0);
		return result;
	}
}
