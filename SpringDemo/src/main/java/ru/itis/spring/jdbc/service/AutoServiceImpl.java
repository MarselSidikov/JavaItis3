package ru.itis.spring.jdbc.service;

import ru.itis.spring.jdbc.dao.AutosDao;
import ru.itis.spring.jdbc.model.Auto;

import java.util.List;

/**
 * Created by admin on 14.01.2017.
 */
public class AutoServiceImpl implements AutoService {

    private AutosDao autosDao;

    public AutoServiceImpl(AutosDao autosDao) {
        this.autosDao = autosDao;
    }

    public List<Auto> getAllAutos() {
        return autosDao.findAll();
    }

    public void addAuto(String model) {
        autosDao.save(new Auto(10L, model, null));
    }
}
