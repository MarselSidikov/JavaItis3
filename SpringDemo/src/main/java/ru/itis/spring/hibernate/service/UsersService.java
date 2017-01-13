package ru.itis.spring.hibernate.service;

import ru.itis.spring.hibernate.models.User;

import java.util.List;

public interface UsersService {
    List<User> getAllUsers();
}
