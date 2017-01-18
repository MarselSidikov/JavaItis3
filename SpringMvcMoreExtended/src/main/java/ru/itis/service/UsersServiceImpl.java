package ru.itis.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.dao.UsersDao;
import ru.itis.models.User;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersDao usersDao;

    public List<User> getAllUsers() {
        return usersDao.findAll();
    }

    public void save(User user) {
        usersDao.save(user);
    }
}
