package ru.itis.simple;

public class Human {

    private String name;
    private int age;
    private char sex;
    private String nation;
    private boolean isMongol;
    private boolean isCrocodile;

    public Human(String name, int age, char sex, String nation, boolean isMongol, boolean isCrocodile) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.nation = nation;
        this.isMongol = isMongol;
        this.isCrocodile = isCrocodile;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public char getSex() {
        return sex;
    }

    public String getNation() {
        return nation;
    }

    public boolean isMongol() {
        return isMongol;
    }

    public boolean isCrocodile() {
        return isCrocodile;
    }
}
