package ru.itis.example.servlet;

import org.springframework.context.ApplicationContext;
import ru.itis.example.renders.MessageRenderer;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class SimpleServlet extends HttpServlet {

    private MessageRenderer renderer;

    public void init(ServletConfig config) {
        ApplicationContext context = (ApplicationContext)config.getServletContext().getAttribute("exampleSpringContext");
        renderer = (MessageRenderer)context.getBean("render");

    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            PrintWriter writer = response.getWriter();
            renderer.printMessage(writer);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
