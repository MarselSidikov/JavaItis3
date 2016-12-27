package ru.itis.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Program {
    public static void main(String[] args) throws Exception {
        Class<Human> humanClass = Human.class;

        // вызывается конструтор пустой
        Human human = humanClass.newInstance();

        Constructor<Human> humanConstructor = humanClass.getConstructor(int.class, String.class);

        Human human1 = humanConstructor.newInstance(10, "Marsel");
        System.out.println(human1.publicStringField);

        Method method = humanClass.getMethod("someMethod");
        method.invoke(human1);

        method = humanClass.getMethod("someMethod", int.class);
        method.invoke(human, 10);

        Field field = humanClass.getDeclaredField("privateIntField");
        field.setAccessible(true);
        field.set(human, 100);

        System.out.println(human.getPrivateIntField());

        Field someField = Integer.class.getDeclaredField("value");
        someField.setAccessible(true);
        someField.set(1, 2);
        System.out.println(Integer.valueOf(1));
        Integer i1 = 5 - 4;
        System.out.println(i1);
    }
}
