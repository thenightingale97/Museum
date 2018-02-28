package com.museum.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "guardian")
public class Guardian extends IdentifiableEntity<Integer> {

    @Column
    private String firstName;

    @Column
    private String lastName;

    @OneToMany(mappedBy = "guardian")
    private List<Hall> halls;

    public Guardian() {

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
        if (!(o instanceof Guardian)) return false;
        if (!super.equals(o)) return false;

        Guardian guardian = (Guardian) o;

        if (firstName != null ? !firstName.equals(guardian.firstName) : guardian.firstName != null) return false;
        if (lastName != null ? !lastName.equals(guardian.lastName) : guardian.lastName != null) return false;
        return halls != null ? halls.equals(guardian.halls) : guardian.halls == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (halls != null ? halls.hashCode() : 0);
        return result;
    }
}
