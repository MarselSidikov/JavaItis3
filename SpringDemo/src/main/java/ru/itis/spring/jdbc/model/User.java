package ru.itis.spring.jdbc.model;

import java.util.List;

public class User {
    private Long id;
    private String name;
    private List<Auto> autos;

    public User(Long id, String name, List<Auto> autos) {
        this.id = id;
        this.name = name;
        this.autos = autos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Auto> getAutos() {
        return autos;
    }

    public void setAutos(List<Auto> autos) {
        this.autos = autos;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
