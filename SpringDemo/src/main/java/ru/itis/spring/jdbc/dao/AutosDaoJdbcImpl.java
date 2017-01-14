package ru.itis.spring.jdbc.dao;

import ru.itis.spring.jdbc.model.Auto;

import java.util.ArrayList;
import java.util.List;

public class AutosDaoJdbcImpl implements AutosDao {
    public List<Auto> findAll() {
        Auto auto = new Auto(10L, "Toyota", null);
        Auto auto1 = new Auto(11L, "KIA", null);
        List<Auto> autos = new ArrayList<Auto>();
        autos.add(auto);
        autos.add(auto1);
        return autos;
    }

    public void save(Auto model) {
        System.out.println("saved");
    }
}
