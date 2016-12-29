package ru.itis.models;

public class Auto {
    private int id;
    private String model;
    private User user;

    public Auto(int id, String model, User user) {
        this.id = id;
        this.model = model;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
