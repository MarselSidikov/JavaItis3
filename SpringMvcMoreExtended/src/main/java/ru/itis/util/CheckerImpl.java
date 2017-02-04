package ru.itis.util;

import org.springframework.stereotype.Component;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

@Component
public class CheckerImpl implements Checker {

    @Override
    public void checkId(Integer id) {
        throw new NotImplementedException();
    }
}
