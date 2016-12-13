package ru.itis.inherritance;

public class Human {
    private int age;
    protected String name;

    public Human(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void introduce() {
        System.out.println("I'm " + name);
    }

    public void sayBye() {
        System.out.println("Bye!");
    }
}
