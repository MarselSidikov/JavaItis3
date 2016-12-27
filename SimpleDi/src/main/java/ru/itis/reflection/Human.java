package ru.itis.reflection;


public class Human {
    public int publicIntField;
    public String publicStringField;

    public int getPrivateIntField() {
        return privateIntField;
    }

    private int privateIntField;

    public Human() {

    }

    public Human(int a, String b) {
        publicIntField = a;
        publicStringField = b;
    }
    public void someMethod() {
        System.out.println("Some method");
    }

    public void someMethod(int a) {
        System.out.println(a);
    }
}
