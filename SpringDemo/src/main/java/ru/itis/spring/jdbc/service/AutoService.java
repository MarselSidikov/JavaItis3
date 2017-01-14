package ru.itis.spring.jdbc.service;

import ru.itis.spring.jdbc.model.Auto;

import java.util.List;

public interface AutoService {
    List<Auto> getAllAutos();
    void addAuto(String name);
}
