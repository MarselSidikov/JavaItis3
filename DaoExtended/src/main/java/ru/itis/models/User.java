package ru.itis.models;

import java.util.List;

public class User {
    private int id;
    private String name;
    private int age;
    private List<Auto> auto;

    public User(int id, String name, int age, List<Auto> auto) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.auto = auto;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Auto> getAuto() {
        return auto;
    }

    public void setAuto(List<Auto> auto) {
        this.auto = auto;
    }
}
