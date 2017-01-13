package ru.itis.spring.hibernate.config;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import ru.itis.spring.hibernate.dao.UsersDao;
import ru.itis.spring.hibernate.dao.UsersDaoHibernateImpl;
import ru.itis.spring.hibernate.models.Child;
import ru.itis.spring.hibernate.service.UsersService;
import ru.itis.spring.hibernate.service.UsersServiceImpl;

import javax.sql.DataSource;

public class ServletsConfigurationPrimitiveJavaConfig {

    @Bean
    public UsersService usersService() {
        return new UsersServiceImpl(usersDaoHibernate());
    }

    @Bean
    public UsersDao usersDaoHibernate() {
        return new UsersDaoHibernateImpl(sessionFactory());
    }

    @Bean
    public SessionFactory sessionFactory() {
        LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource());
        builder.addResource("ru.itis.hibernate/User.hbm.xml");
        builder.addResource("ru.itis.hibernate/Auto.hbm.xml");
        builder.addAnnotatedClass(Child.class);
        builder.setProperty("hibernate.dialect","org.hibernate.dialect.PostgreSQL82Dialect");
        return builder.buildSessionFactory();
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("org.postgresql.Driver");
        driverManagerDataSource.setUrl("jdbc:postgresql://localhost:5432/java_itis_group");
        driverManagerDataSource.setUsername("postgres");
        driverManagerDataSource.setPassword("qwerty007");
        return driverManagerDataSource;
    }
}
