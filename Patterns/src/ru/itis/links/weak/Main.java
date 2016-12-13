package ru.itis.links.weak;

public class Main {
    public static void main(String[] args) {
        C cB = new B();
        C cD = new D();

        A a = new A(cB);
        A a2 = new A(cD);

        a.someMethod();
        a2.someMethod();
    }
}
