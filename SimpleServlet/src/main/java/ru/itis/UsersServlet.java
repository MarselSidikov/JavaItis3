package ru.itis;


import com.sun.org.apache.bcel.internal.generic.LUSHR;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UsersServlet extends HttpServlet {
    private List<User> users;

    public void init(ServletConfig servletConfig) {
        try {
            super.init(servletConfig);
            User marsel = new User("Marsel", "Sidikov");
            User roma = new User("Roma", "Kiselev");
            User leha = new User("Leha", "Kaliev");

            users = new ArrayList<User>();
            users.add(marsel);
            users.add(roma);
            users.add(leha);
        } catch (ServletException e) {
            throw new IllegalArgumentException(e);
        }
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) {

        request.setAttribute("users_list", users);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");

        User user = new User(name, surname);

        users.add(user);
        try {
            getServletContext().getRequestDispatcher("/users.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
