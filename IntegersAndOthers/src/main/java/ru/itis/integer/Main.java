package ru.itis.integer;


// Boolean
// Double
// ...
public class Main {

    // NullPointer
    public int getVaue() {
        return (true) ? null : 0;
    }

    public static void swap(Integer i, Integer i2) {
        Integer temp = i;
        i = i2;
        i2 = temp;
    }

    public static void main(String[] args) {
        int i = 92;
        // i = null;

        // Autoboxing: int -> Integer
        // static Integer Integer.valueOf(int i) {..}
        // Immutable
        Integer integer = 92;
        integer = null;

        // IntegerCache
        Integer i1 = 190;
        Integer i2 = 190;

        System.out.println(i1 == i2);

        i2 = 100;

        swap(i1, i2);

        System.out.println(i2.intValue());

    }
}
