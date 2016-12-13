package ru.itis.interfaces;

public class Main {
    public static void main(String[] args) {
        Bag bag = new BagLinkedListImpl();

        bag.put(10);
        bag.put(8);

        System.out.println(bag.isExist(10));
        System.out.println(bag.isExist(100));
    }
}
