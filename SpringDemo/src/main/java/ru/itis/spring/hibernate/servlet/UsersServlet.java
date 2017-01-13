package ru.itis.spring.hibernate.servlet;


import org.springframework.context.ApplicationContext;
import ru.itis.spring.hibernate.models.User;
import ru.itis.spring.hibernate.service.UsersService;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class UsersServlet extends HttpServlet {

    private UsersService usersService;

    public void init(ServletConfig config) {
        ApplicationContext context = (ApplicationContext)config.getServletContext().getAttribute("hibernateSpringContext");
        usersService = (UsersService) context.getBean("usersService");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        List<User> users = usersService.getAllUsers();
        try {
            PrintWriter writer = response.getWriter();
            for (User user : users) {
                writer.write("<p>" + user + "</p>");
            }
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
