package ru.itis.factories;

import ru.itis.dao.UsersDao;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class DaoFactory {
    private static DaoFactory instance;

    private UsersDao usersDao;

    static {
        instance = new DaoFactory();
    }

    private DaoFactory() {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("C:\\Users\\admin.WIN-IPM3OA3VQNQ\\Desktop\\JAVA\\JavaItis3\\DaoExtended\\" +
                    "src\\main\\resources\\ru.itis\\context.properties"));
        } catch (IOException e) {
            throw new IllegalArgumentException();
        }

        String daoClassName = properties.getProperty("users.dao.class");
        try {
            Constructor<?> constructor = Class.forName(daoClassName).getConstructor(DataSource.class);
            usersDao = (UsersDao)constructor.newInstance(DataSourceFactory.getInstance().getDataSource());
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

    public static DaoFactory getInstance() {
        return instance;
    }

    public UsersDao getUsersDao() {
        return usersDao;
    }
}
