package ru.itis.config;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import ru.itis.models.Child;

import javax.sql.DataSource;

@Configuration
@EnableWebMvc
@ComponentScan("ru.itis")
public class SpringConfig {

    @Bean
    public ViewResolver viewResolver() {
        return new InternalResourceViewResolver("/WEB-INF/views/", ".jsp");
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
