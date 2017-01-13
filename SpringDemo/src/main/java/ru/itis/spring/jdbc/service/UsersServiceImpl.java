package ru.itis.spring.jdbc.service;

import ru.itis.spring.jdbc.dao.UsersDao;
import ru.itis.spring.jdbc.model.User;

import java.util.List;

public class UsersServiceImpl implements UsersService {

    private UsersDao usersDao;

    public UsersServiceImpl(UsersDao usersDao) {
        this.usersDao = usersDao;
    }

    public List<User> getAllUsers() {
        return usersDao.findAll();
    }
}
