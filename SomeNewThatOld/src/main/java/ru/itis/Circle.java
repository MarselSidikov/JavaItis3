package ru.itis;

public class Circle {
    private int x;
    private int y;
    private double radius;

    public Circle(int x, int y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    // Если объекты равны по equals, они 100% равны по hashCode
    public int hashCode() {
        return x + y + (int)radius;
    }

    public boolean equals(Object object) {
        if (object == null || !object.getClass().equals(this.getClass())) {
            return false;
        } else {
            Circle that = (Circle)object;
            return this.x == that.x && this.y == that.y &&
                    this.radius == this.radius;
        }
    }
}
