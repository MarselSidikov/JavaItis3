package ru.itis.generics;

public class ArrayListObjects {
    private final static int MAX_SIZE = 5;
    private Object elements[];
    private int count;

    public ArrayListObjects() {
        elements = new Object[MAX_SIZE];
        count = 0;
    }

    public void add(Object element) {
        if (count < MAX_SIZE) {
            this.elements[count] = element;
            count++;
        } else {
            System.out.println("ERROR");
        }
    }

    public Object get(int index) {
        if (index < count) {
            return elements[index];
        } else {
            return null;
        }
    }
}
