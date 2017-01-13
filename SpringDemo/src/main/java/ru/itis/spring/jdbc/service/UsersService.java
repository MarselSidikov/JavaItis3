package ru.itis.spring.jdbc.service;

import ru.itis.spring.jdbc.model.User;

import java.util.List;

public interface UsersService {
    List<User> getAllUsers();
}
