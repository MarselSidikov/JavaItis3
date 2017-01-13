package ru.itis.spring.hibernate.dao;


import ru.itis.spring.hibernate.models.User;

import java.util.List;

public interface UsersDao {
    List<User> findAll();
}
