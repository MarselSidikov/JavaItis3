package ru.itis.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.dao.UsersDao;
import ru.itis.models.Auto;
import ru.itis.models.User;
import ru.itis.util.Checker;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersDao usersDao;

    @Autowired
    private Checker checker;

    UsersServiceImpl(UsersDao usersDao, Checker checker) {
        this.usersDao = usersDao;
        this.checker = checker;
    }

    public UsersServiceImpl() {

    }

    public Checker checker() {
        return checker;
    }
    public List<User> getAllUsers() {
        return usersDao.findAll();
    }

    public void save(User user) {
        checker.checkId(user.getId());
        usersDao.save(user);
    }

    @Override
    public List<Auto> getAutoByUserId(Integer id) {
        return usersDao.findAutoByUserId(id);
    }



}
