package ru.itis.spring.jdbc.servlet;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FrontController extends HttpServlet {
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("HELLO");
        String requestMethod = req.getMethod();
        String requestUri = req.getRequestURI();

        if (requestMethod.equals("PUT") && requestUri.equals("/users")) {
            req.getRequestDispatcher("/users").forward(req, resp);
        } else {
            req.getRequestDispatcher("example.jsp").forward(req, resp);
        }
    }

}
