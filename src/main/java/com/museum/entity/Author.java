package com.museum.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="author")
public class Author {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column
	private String firstName;
	
	@Column
	private String lastName;
	
	@Column
	@OneToMany(mappedBy="author")
	private List<Showpiece> showpieces;
	
	public Author() {
		
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
		
		Author author = (Author) o;
		
		if (id != author.id) return false;
		if (firstName != null ? !firstName.equals(author.firstName) : author.firstName != null) return false;
		if (lastName != null ? !lastName.equals(author.lastName) : author.lastName != null) return false;
		return showpieces != null ? showpieces.equals(author.showpieces) : author.showpieces == null;
	}
	
	@Override
	public int hashCode() {
		int result = id;
		result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
		result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
		result = 31 * result + (showpieces != null ? showpieces.hashCode() : 0);
		return result;
	}
}
