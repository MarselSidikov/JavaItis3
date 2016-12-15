package ru.itis.string;

/**
 * StringBuilder
 * StringBuffer
 * https://habrahabr.ru/post/79913/
 * https://habrahabr.ru/post/222443/
 */
public class Main {
    public static void main(String[] args) {
        /**
         * StringPool
         * От строк нельзя наследоваться
         * Строки неизменяемые
         * Класс String агрегирует в себе финальное поле
         * типа char[]
         */
        String hello = "Hello";
        String hello2 = "Hello";
        String hello3 = new String("Hello");

        System.out.println(hello == hello2);
        System.out.println(hello == hello3);
        System.out.println(hello.equals(hello3));
        System.out.println(hello == hello3.intern());



        int i = 7;
        i += 10; // 17

        String myString = "Hello";
        myString+="Bye";

        System.out.println(myString.equals("HelloBye"));
    }
}
