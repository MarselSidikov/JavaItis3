package ru.itis;

public class A {
    public int value;
    // статичное поле - глобальное
    public static int staticValue = 10;

    static {
        staticValue = 100;
    }
}
