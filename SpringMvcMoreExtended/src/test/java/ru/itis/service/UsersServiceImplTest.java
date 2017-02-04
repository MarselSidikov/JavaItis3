package ru.itis.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.itis.models.Auto;
import ru.itis.models.User;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static ru.itis.data.TestData.MARSEL_AUTOS;
import static ru.itis.data.TestData.MARSEL_USER_ID;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfig.class)
public class UsersServiceImplTest {

    @Autowired
    UsersServiceImpl usersService;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testGetAllUsers() throws Exception {
        System.out.println(usersService.getAllUsers().get(0).getName());
    }

    @Test
    public void testGetAutoById() throws Exception {
        List<Auto> expected = MARSEL_AUTOS;
        List<Auto> actual = usersService.getAutoByUserId(MARSEL_USER_ID);

        assertEquals(expected.get(0), actual.get(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetAutoByIdOnIncorrectData() throws Exception {
        usersService.getAutoByUserId(10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void saveOnIncorrectData() throws Exception {
        usersService.save(new User(1,"Vicktor", null, 33));
    }

    @Test
    public void saveOnCorrectData() throws Exception {
        usersService.save(new User(10,"Vicktor", null, 33));
        verify(usersService.checker()).checkId(10);
    }
}