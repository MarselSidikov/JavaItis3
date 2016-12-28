package ru.itis.dao;

import ru.itis.models.User;

public interface UsersDao extends Dao<User> {
    User findAllByAge(int age);
}
