package ru.itis.spring.hibernate.service;


import org.springframework.beans.factory.annotation.Autowired;
import ru.itis.spring.hibernate.dao.UsersDao;
import ru.itis.spring.hibernate.models.User;

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
