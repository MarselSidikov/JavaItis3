package ru.itis.dao;

import ru.itis.models.Auto;

import java.util.List;

public interface AutoDao extends Dao<Auto> {
    List<Auto> findByUser(int userId);
}
