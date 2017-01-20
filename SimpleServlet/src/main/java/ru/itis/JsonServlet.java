package ru.itis;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

public class JsonServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        User user = new User("Marsel", "Sidikov");
        User user1 = new User("Almaz", "Zabirov");
        User user2 = new User("Denis", "Denisov");

        List<User> list = Arrays.asList(user, user1, user2);
        user.setValues(new int[] {1, 2, 3});
        user.setUser(user1);

        ObjectMapper mapper = new ObjectMapper();

        try {
            String jsonValue = mapper.writeValueAsString(user);
            response.setStatus(200);
            response.setHeader("Servlet status", "All okey");
            response.setContentType("application/json");
            PrintWriter writer = response.getWriter();

            writer.write(jsonValue);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException(e);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }

    }
}
