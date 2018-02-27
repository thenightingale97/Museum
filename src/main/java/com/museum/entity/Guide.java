package com.museum.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name="guide")
public class Guide extends IdentifiableEntity<Integer> {
	
	@Column
	private String firstName;
	
	@Column
	private String lastName;
	
	@Column
	private String phoneNumber;
	
	@Column
	private GuidePosition position;
	
	@Column
	@OneToMany(mappedBy="guide")
	private List<Event> events;
	
	public Guide () {
		
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

	public GuidePosition getPosition() {
		return position;
	}

	public void setPosition(GuidePosition position) {
		this.position = position;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Guide)) return false;
		if (!super.equals(o)) return false;
		
		Guide guide = (Guide) o;
		
		if (firstName != null ? !firstName.equals(guide.firstName) : guide.firstName != null) return false;
		if (lastName != null ? !lastName.equals(guide.lastName) : guide.lastName != null) return false;
		if (phoneNumber != null ? !phoneNumber.equals(guide.phoneNumber) : guide.phoneNumber != null) return false;
		if (position != guide.position) return false;
		return events != null ? events.equals(guide.events) : guide.events == null;
	}
	
	@Override
	public int hashCode() {
		int result = super.hashCode();
		result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
		result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
		result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
		result = 31 * result + (position != null ? position.hashCode() : 0);
		result = 31 * result + (events != null ? events.hashCode() : 0);
		return result;
	}
}
