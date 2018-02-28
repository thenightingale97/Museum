package com.museum.model.request;

public class HallRequest {

    private Integer id;

    private Integer guardian;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGuardian() {
        return guardian;
    }

    public void setGuardian(Integer guardian) {
        this.guardian = guardian;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
