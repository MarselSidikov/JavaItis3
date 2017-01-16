package ru.itis.service;

import ru.itis.model.User;
import org.springframework.stereotype.Component;

@Component
public class UsersServiceImpl implements UsersService {
    public User getUser() {
        return new User("Marsel", "qwerty007");
    }
}
