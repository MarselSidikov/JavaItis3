package ru.itis.generics.token.example;

public class PasswordNumber implements Type {
    private String typeName;

    private int series;
    private int number;

    public PasswordNumber(String typeName, int series, int number) {
        this.typeName = typeName;
        this.series = series;
        this.number = number;
    }

    public String getTypeName() {
        return typeName;
    }

    public int getSeries() {
        return series;
    }

    public int getNumber() {
        return number;
    }
}
