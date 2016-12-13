package ru.itis.singleton;

public class Main {
    public static void main(String[] args) {
        int value = SingletonExample.getInstance().getSomeField();
        System.out.println(value);
    }
}
