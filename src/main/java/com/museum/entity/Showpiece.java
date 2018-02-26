package com.museum.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="showpiece")
public class Showpiece {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	    
	@Column
	private String name;
	
	@Column
	private ShowpieceTechnique technique;
    
	@Column
	private ShowpieceMaterial material;
    
	@ManyToOne
	private Author author;
	
	@ManyToMany(mappedBy="showpieces")
	private List<Excursion> excursions;
	
	@ManyToOne
	private Hall hall;

	@Column
	private String imageUrl;
	
	public Showpiece() {
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
}
