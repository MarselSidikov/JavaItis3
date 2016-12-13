package ru.itis;

public class A {
    public int value;
    // статичное поле - глобальное
    public static int staticValue = 10;

    static {
        staticValue = 100;
    }

    public void someMethod() {
        staticValue = 10;
    }

    public static void staticMethod() {
        // value = 5;
        staticValue = 500;
    }
}
