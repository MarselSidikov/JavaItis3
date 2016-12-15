package ru.itis.generics;

public class ArrayListGenerics<T> {
    private final static int MAX_SIZE = 5;
    private Object elements[];
    private int count;

    public ArrayListGenerics() {
        elements = new Object[MAX_SIZE];
        count = 0;
    }

    public void add(T element) {
        if (count < MAX_SIZE) {
            this.elements[count] = element;
            count++;
        } else {
            System.out.println("ERROR");
        }
    }

    public T get(int index) {
        if (index < count) {
            return (T)elements[index];
        } else {
            return null;
        }
    }
}
