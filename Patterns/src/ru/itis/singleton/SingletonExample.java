package ru.itis.singleton;

public class SingletonExample {
    private static SingletonExample instance;

    private int someField;

    private SingletonExample() {
        this.someField = 100;
    }

    static {
        instance = new SingletonExample();
    }

    public int getSomeField() {
        return someField;
    }

    public static SingletonExample getInstance() {
        return instance;
    }
}
