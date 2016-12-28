package ru.itis.dao;

import java.util.List;

public interface Dao<T> {
    int add(T model);
    T find(int id);
    List<T> findAll();
}
