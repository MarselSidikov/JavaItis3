package ru.itis.abstracts;

public class Auto extends Transport {

    public Auto(String type) {
        super(type);
    }

    @Override
    public void go() {
        System.out.println("Auto go");
    }
}
