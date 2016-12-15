package ru.itis.generics.extend;

public class Main {
    public static void main(String[] args) {
        A a = new A();
        C c = new C();
        SomeGeneric<A, C> someGeneric = new SomeGeneric<A, C>(a, c);
        someGeneric.getE().showC();
        someGeneric.getT().showA();
    }
}
