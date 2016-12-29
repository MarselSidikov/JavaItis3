package ru.itis.factories;

import ru.itis.dao.UsersDao;
import ru.itis.service.UsersService;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class ServiceFactory {
    private static ServiceFactory instance;

    private UsersService usersService;

    static {
        instance = new ServiceFactory();
    }

    private ServiceFactory() {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("C:\\Users\\admin.WIN-IPM3OA3VQNQ\\Desktop\\JAVA\\JavaItis3\\DaoExtended\\" +
                    "src\\main\\resources\\ru.itis\\context.properties"));
        } catch (IOException e) {
            throw new IllegalArgumentException();
        }

        String serviceClassName = properties.getProperty("users.service.class");
        try {
            Constructor<?> constructor = Class.forName(serviceClassName).getConstructor(UsersDao.class);
            usersService = (UsersService)constructor.newInstance(DaoFactory.getInstance().getUsersDao());
        } catch (NoSuchMethodException e) {
            throw new IllegalArgumentException();
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException();
        } catch (IllegalAccessException e) {
            throw new IllegalArgumentException();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


    }

    public static ServiceFactory getInstance() {
        return instance;
    }

    public UsersService getUsersService() {
        return usersService;
    }
}
