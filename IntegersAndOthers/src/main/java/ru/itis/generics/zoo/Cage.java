package ru.itis.generics.zoo;


public class Cage<T extends Human & Animal> {

    private T object;

    public void add(T object) {
        this.object = object;
    }

    public T get() {
        return this.object;
    }
}
