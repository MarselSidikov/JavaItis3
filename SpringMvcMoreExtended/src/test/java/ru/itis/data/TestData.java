package ru.itis.data;

import ru.itis.models.Auto;
import ru.itis.models.User;

import java.util.Arrays;
import java.util.List;

public class TestData {
    public static final List<User> USERS = createUsers();
    public static final List<Auto> MARSEL_AUTOS = createMarselAuto();

    public static final User MARSEL_USER = new User(1, "Marsel", null, 23);

    public static final User SASHA_USER = new User(2, "Sasha", null, 22);
    public static final User OKSANA_USER = new User(3, "Oksana", null, 18);
    public static final Integer MARSEL_USER_ID = 1;
    public static final Auto MARSEL_AUTO = new Auto(1, "Toyota", MARSEL_USER);

    private static List<User> createUsers() {
        return Arrays.asList(MARSEL_USER, SASHA_USER, OKSANA_USER);
    }

    private static List<Auto> createMarselAuto() {
        return Arrays.asList(MARSEL_AUTO);
    }


}
