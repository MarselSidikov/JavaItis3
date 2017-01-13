package ru.itis.spring.hibernate.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class SpringServletContextListenerForHibernateProject implements ServletContextListener {
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        //ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ru.itis.context\\servlet-spring-hibernate.xml");
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ServletsConfigurationPrimitiveJavaConfig.class);
        servletContextEvent.getServletContext().setAttribute("hibernateSpringContext", applicationContext);
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
