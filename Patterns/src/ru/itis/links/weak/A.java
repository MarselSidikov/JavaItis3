package ru.itis.links.weak;

public class A {
    C c;

    public A(C c) {
        this.c = c;
    }

    public void someMethod() {
        c.someMethod();
    }
}
