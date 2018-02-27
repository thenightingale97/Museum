package com.museum.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="guardian")
public class Guardian {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column
	private String firstName;
	
	@Column
	private String lastName;
	
	@OneToMany(mappedBy="guardian")
	private List<Hall> halls;
	
	public Guardian() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public List<Hall> getHalls() {
		return halls;
	}

	public void setHalls(List<Hall> halls) {
		this.halls = halls;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		
		Guardian guardian = (Guardian) o;
		
		if (id != guardian.id) return false;
		if (firstName != null ? !firstName.equals(guardian.firstName) : guardian.firstName != null) return false;
		if (lastName != null ? !lastName.equals(guardian.lastName) : guardian.lastName != null) return false;
		return halls != null ? halls.equals(guardian.halls) : guardian.halls == null;
	}
	
	@Override
	public int hashCode() {
		int result = id;
		result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
		result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
		result = 31 * result + (halls != null ? halls.hashCode() : 0);
		return result;
	}
}
