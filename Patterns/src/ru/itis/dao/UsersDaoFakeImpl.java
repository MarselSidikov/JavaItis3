package ru.itis.dao;

public class UsersDaoFakeImpl implements UsersDao {
    @Override
    public User[] findAll() {
        User marsel = new User(22, "Marsel");
        User nastya = new User(18, "Nastya");

        return new User[]{marsel, nastya};
    }
}
