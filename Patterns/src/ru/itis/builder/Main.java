package ru.itis.builder;

public class Main {
    public static void main(String[] args) {
        Human human = new Human.Builder()
                .age(22)
                .isMongol(true)
                .nation("Mongol")
                .isCrocodile(false)
                .build();
    }
}
