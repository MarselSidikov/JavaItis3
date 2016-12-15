package ru.itis.generics;

public class ArrayListIntegers {
    private final static int MAX_SIZE = 5;
    private int elements[];
    private int count;

    public ArrayListIntegers() {
        elements = new int[MAX_SIZE];
        count = 0;
    }

    public void add(int element) {
        if (count < MAX_SIZE) {
            this.elements[count] = element;
            count++;
        } else {
            System.out.println("ERROR");
        }
    }

    public int get(int index) {
        if (index < count) {
            return elements[index];
        } else {
            return -999;
        }
    }
}
