package ru.itis.service;


import ru.itis.dao.UsersDao;
import ru.itis.models.User;

import java.util.List;

public class UsersServiceImpl implements UsersService {
    private UsersDao usersDao;

    public UsersServiceImpl(UsersDao usersDao) {
        this.usersDao = usersDao;
    }

    public User getUser(int id) {
        return usersDao.find(id);
    }

    public boolean isRegistered(String login) {
        List<User> users = usersDao.findAll();

        for (User user : users) {
            if (user.getName().equals(login)) {
                return true;
            }
        }

        return false;
    }
}
