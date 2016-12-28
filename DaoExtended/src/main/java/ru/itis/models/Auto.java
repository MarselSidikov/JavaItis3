package ru.itis.models;

public class Auto {
    private int id;
    private String model;
    private String color;
    private User user;

    public Auto(int id, String model, String color, User user) {
        this.id = id;
        this.model = model;
        this.color = color;
        this.user = user;
    }
}
