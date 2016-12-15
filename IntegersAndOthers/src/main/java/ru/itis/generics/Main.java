package ru.itis.generics;

import ru.itis.generics.zoo.Animal;
import ru.itis.generics.zoo.Cat;
import ru.itis.generics.zoo.Dog;

import java.util.ArrayList;

public class Main {

    private static <T, E> T someMethod(T a, T b) {
        return a;
    }

    private static <T, E> String someMethod2(T a, E b) {
        return a.toString() + b.toString();
    }


    public static void main(String[] args) {
        ArrayListIntegers list = new ArrayListIntegers();
        list.add(5);
        list.add(6);
        list.add(7);

        int valueFromList = list.get(1);
        System.out.println(valueFromList);

        ArrayListObjects listOfCharacters = new ArrayListObjects();
        listOfCharacters.add('s');
        listOfCharacters.add('v');

        // Unboxing
        char charValueFromList = (Character)listOfCharacters.get(1);

        System.out.println(charValueFromList);

        listOfCharacters.add("100500");

        // charValueFromList = (Character)listOfCharacters.get(2);

        ArrayListGenerics<Integer> listGenerics = new ArrayListGenerics<Integer>();
        listGenerics.add(10);
        listGenerics.add(11);
        listGenerics.add(15);

        // listGenerics.add("String");

        valueFromList = listGenerics.get(1);
        System.out.println(valueFromList);

        Integer i1 = 123;
        Integer i2 = 124;
        // String a = someMethod(i1, i2);
        Integer result = someMethod(i1, i2);
        String a = someMethod("Hello", "Hello");
        System.out.println(someMethod2(i1, a));

        //--------------------------------------------------------
        /**
        ArrayListGenerics<Number> integerArrayListGenerics;

        integerArrayListGenerics = new ArrayListGenerics<Integer>();
        **/

        ArrayListGenerics<?> arrayListGenerics;
        arrayListGenerics = new ArrayListGenerics<Integer>();
        arrayListGenerics = new ArrayListGenerics<String>();

        // String string = arrayListGenerics.get(2);
        Object object = arrayListGenerics.get(1);

        /**
        ArrayListGenerics<Animal> animalList = new ArrayListGenerics<Dog>();
        animalList.add(new Cat());
         **/

        ArrayListGenerics<? extends Animal> animalList = new ArrayListGenerics<Dog>();
        /**
        animalList.add(new Dog());
        animalList.add(new Cat());
        **/

        ArrayListGenerics<? extends Number> numbersList = new ArrayListGenerics<Integer>();
        numbersList = listGenerics;
        Number number = numbersList.get(1);
        // Integer integer = numbersList.get(1);

        // ArrayListGenerics<Integer> integerArrayListGenerics = new ArrayListGenerics<Number>();
        ArrayListGenerics<? super Integer> integerArrayListGenerics =
                new ArrayListGenerics<Object>();

        integerArrayListGenerics.add(23);
        // integerArrayListGenerics.add("Hello");
        Object u = integerArrayListGenerics.get(1);
    }
}
