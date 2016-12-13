package ru.itis.inherritance;

public class Flash extends Human {

    private int speed;

    public Flash(int age, String name, int speed) {
        super(age, name);
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void introduce() {
        System.out.println("I'm " + super.name + " and I'm superhero");
    }
}
