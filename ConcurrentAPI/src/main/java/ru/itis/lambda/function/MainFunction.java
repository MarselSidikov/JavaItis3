package ru.itis.lambda.function;

import java.util.function.Function;
import java.util.function.Predicate;

public class MainFunction {
    public static void main(String[] args) {
        Function<User, String> stringRepresentOfUserNameAndAge = user -> user.getName() + " " + user.getAge();

        Function<User, String> stringRepresentOfUserCountOfAuto = user ->
            user.getAutoCounts() + "";

        Predicate<User> autoCounts = user -> user.getAutoCounts() > 0;

        User user = new User(22, "Marsel", 0);
        autoCounts.test(user);

        String nameAndAge = stringRepresentOfUserNameAndAge.apply(user);
        String autoCount = stringRepresentOfUserCountOfAuto.apply(user);

        System.out.println(nameAndAge);
        System.out.println(autoCount);
    }
}
