package ru.itis.dao;


import ru.itis.models.Auto;
import ru.itis.models.User;

import java.util.List;

public interface UsersDao {
    List<User> findAll();
    void save(User user);

    List<Auto> findAutoByUserId(Integer id);
}
