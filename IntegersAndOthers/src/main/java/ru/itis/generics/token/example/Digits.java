package ru.itis.generics.token.example;

public class Digits implements Type {
    private String typeName;
    private int value;

    public Digits(String typeName, int value) {
        this.typeName = typeName;
        this.value = value;
    }

    public String getTypeName() {
        return typeName;
    }

    public int getValue() {
        return value;
    }
}
