package ru.itis;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class SimpleServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            PrintWriter printWriter = response.getWriter();
            printWriter.write("<p> Hello and Bye!!!! </p>");
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}
