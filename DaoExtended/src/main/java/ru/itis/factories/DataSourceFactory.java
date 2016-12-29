package ru.itis.factories;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class DataSourceFactory {
    private static DataSourceFactory instance;

    private DataSource dataSource;

    static {
        try {
            instance = new DataSourceFactory();
        } catch (IOException e) {
            throw new IllegalArgumentException();
        }
    }

    private DataSourceFactory() throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("C:\\Users\\admin.WIN-IPM3OA3VQNQ\\Desktop\\JAVA\\JavaItis3\\DaoExtended\\" +
                "src\\main\\resources\\ru.itis\\context.properties"));

        String driverClassName = properties.getProperty("db.driver");
        String dbUrl = properties.getProperty("db.url");
        String dbUserName = properties.getProperty("db.user.name");
        String dbPassword = properties.getProperty("db.password");

        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName(driverClassName);
        driverManagerDataSource.setUrl(dbUrl);
        driverManagerDataSource.setUsername(dbUserName);
        driverManagerDataSource.setPassword(dbPassword);
        dataSource = driverManagerDataSource;
    }

    public static DataSourceFactory getInstance() {
        return instance;
    }

    public DataSource getDataSource() {
        return dataSource;
    }
}
