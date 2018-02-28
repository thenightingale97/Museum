package com.museum.model.request;

import com.museum.entity.ShowpieceMaterial;
import com.museum.entity.ShowpieceTechnique;

public class ShowpieceRequest {

    private String name;

    private Integer id;

    private String creationDate;

    private ShowpieceTechnique technique;

    private ShowpieceMaterial material;

    private Integer author;

    private Integer hall;

    private String imageUrl;

    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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

    public void setTechnique(ShowpieceTechnique technique) {
        this.technique = technique;
    }

    public ShowpieceMaterial getMaterial() {
        return material;
    }

    public void setMaterial(ShowpieceMaterial material) {
        this.material = material;
    }

    public Integer getAuthor() {
        return author;
    }

    public void setAuthor(Integer author) {
        this.author = author;
    }

    public Integer getHall() {
        return hall;
    }

    public void setHall(Integer hall) {
        this.hall = hall;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
