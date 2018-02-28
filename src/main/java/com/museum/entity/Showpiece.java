package com.museum.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "showpiece")
public class Showpiece extends IdentifiableEntity<Integer> {
    
    @Column
    private String name;
    
    @Column
    private ShowpieceTechnique technique;
    
    @Column
    private ShowpieceMaterial material;
    
    @ManyToOne
    private Author author;
    
    @ManyToMany(mappedBy = "showpieces")
    private List<Excursion> excursions;
    
    @ManyToOne
    private Hall hall;
    
    @Column
    private String imageUrl;
    
    @Column
    private String description;
    
    @Column
    private LocalDate creationDate;
    
    public Showpiece() {
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public ShowpieceTechnique getTechnique() {
        return technique;
    }
    
    public void setTechnique(ShowpieceTechnique type) {
        this.technique = type;
    }
    
    public Author getAuthor() {
        return author;
    }
    
    public void setAuthor(Author author) {
        this.author = author;
    }
    
    public ShowpieceMaterial getMaterial() {
        return material;
    }
    
    public void setMaterial(ShowpieceMaterial material) {
        this.material = material;
    }
    
    public Hall getHall() {
        return hall;
    }
    
    public void setHall(Hall hall) {
        this.hall = hall;
    }
    
    public List<Excursion> getExcursions() {
        return excursions;
    }
    
    public void setExcursions(List<Excursion> excursions) {
        this.excursions = excursions;
    }
    
    public String getImageUrl() {
        return imageUrl;
    }
    
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public LocalDate getCreationDate() {
        return creationDate;
    }
    
    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Showpiece)) return false;
        if (!super.equals(o)) return false;
        
        Showpiece showpiece = (Showpiece) o;
        
        if (name != null ? !name.equals(showpiece.name) : showpiece.name != null) return false;
        if (technique != showpiece.technique) return false;
        if (material != showpiece.material) return false;
        if (author != null ? !author.equals(showpiece.author) : showpiece.author != null) return false;
        if (excursions != null ? !excursions.equals(showpiece.excursions) : showpiece.excursions != null) return false;
        if (hall != null ? !hall.equals(showpiece.hall) : showpiece.hall != null) return false;
        if (imageUrl != null ? !imageUrl.equals(showpiece.imageUrl) : showpiece.imageUrl != null) return false;
        if (description != null ? !description.equals(showpiece.description) : showpiece.description != null)
            return false;
        return creationDate != null ? creationDate.equals(showpiece.creationDate) : showpiece.creationDate == null;
    }
    
    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (technique != null ? technique.hashCode() : 0);
        result = 31 * result + (material != null ? material.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (excursions != null ? excursions.hashCode() : 0);
        result = 31 * result + (hall != null ? hall.hashCode() : 0);
        result = 31 * result + (imageUrl != null ? imageUrl.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (creationDate != null ? creationDate.hashCode() : 0);
        return result;
    }

    /*@Override
    public String toString() {
        return "Showpiece{" +
                "name='" + name + '\'' +
                ", technique=" + technique +
                ", material=" + material +
                ", author=" + author +
                ", excursions=" + excursions +
                ", hall=" + hall +
                ", imageUrl='" + imageUrl + '\'' +
                ", description='" + description + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }*/
}
