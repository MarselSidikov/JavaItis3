package ru.itis.service;

import ru.itis.models.User;

import java.util.List;

public interface UsersService {
    User getUser(int id);
    boolean isRegistered(String login);
}
