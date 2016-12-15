package ru.itis.generics.extend;


public class SomeGeneric<T, E> {
    private T t;
    private E e;
    private int a;

    public SomeGeneric(T t, E e) {
        this.t = t;
        this.e = e;
    }

    public T getT() {
        return t;
    }

    public E getE() {
        return e;
    }
}
