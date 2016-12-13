package ru.itis.links.strong;

public class A {
    B b;

    public A() {
        b = new B();
    }

    public void someMethod() {
        b.someMethod();
    }
}
