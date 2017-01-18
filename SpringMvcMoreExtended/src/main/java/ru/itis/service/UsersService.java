package ru.itis.service;


import ru.itis.models.User;

import java.util.List;

public interface UsersService {
    List<User> getAllUsers();
    void save(User user);
}
