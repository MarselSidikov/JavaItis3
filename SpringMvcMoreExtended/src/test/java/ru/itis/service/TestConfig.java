package ru.itis.service;

import org.mockito.Matchers;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.itis.dao.UsersDao;

import ru.itis.util.Checker;

import static org.mockito.Mockito.*;
import static ru.itis.data.TestData.MARSEL_AUTOS;
import static ru.itis.data.TestData.MARSEL_USER_ID;
import static ru.itis.data.TestData.USERS;

@Configuration
public class TestConfig {

    @Bean
    UsersServiceImpl usersService() {
        return new UsersServiceImpl(usersDao(), checker());
    }

    @Bean
    UsersDao usersDao() {
        UsersDao usersDao = Mockito.mock(UsersDao.class);

        when(usersDao.findAll()).thenReturn(USERS);
        doThrow(IllegalArgumentException.class).when(usersDao).findAutoByUserId(Matchers.anyInt());
        doReturn(MARSEL_AUTOS).when(usersDao).findAutoByUserId(MARSEL_USER_ID);
        return usersDao;
    }

    @Bean
    Checker checker() {
        Checker checker = Mockito.mock(Checker.class);
        doNothing().when(checker).checkId(anyInt());
        doThrow(IllegalArgumentException.class).when(checker).checkId(1);
        return checker;
    }
}
