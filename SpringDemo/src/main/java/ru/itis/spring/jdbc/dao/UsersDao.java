package ru.itis.spring.jdbc.dao;

import ru.itis.spring.jdbc.model.User;

import java.util.List;

public interface UsersDao {
    List<User> findAll();
    User find(int id);
}
