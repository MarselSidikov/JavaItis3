package ru.itis.interfaces;


public class BagArrayImpl implements Bag {

    private static int MAX_SIZE = 10;

    private int elements[];
    private int count;

    public BagArrayImpl() {
        this.elements = new int[MAX_SIZE];
        this.count = 0;
    }

    @Override
    public void put(int number) {
        if (count < MAX_SIZE) {
            this.elements[count] = number;
            count++;
        } else {
            System.out.println("Bag is full");
        }
    }

    @Override
    public boolean isExist(int number) {
        for (int i = 0; i < count; i++) {
            if (elements[i] == number) {
                return true;
            }
        }

        return false;
    }
}
