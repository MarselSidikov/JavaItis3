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
        instance = new DataSourceFactory();
    }

    private DataSourceFactory() throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("C:\\Users\\admin.WIN-IPM3OA3VQNQ\\Desktop\\JAVA\\JavaItis3\\DaoExtended\\" +
                "src\\main\\resources\\ru.itis\\context.properties"));

        String driverClassName = properties.getProperty("db.driver");
        //

        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName(driverClassName);

        dataSource = driverManagerDataSource;
    }

}
