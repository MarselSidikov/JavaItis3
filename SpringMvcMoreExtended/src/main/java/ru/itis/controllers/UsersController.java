package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.models.User;
import ru.itis.service.UsersService;

import java.util.List;

@Controller
public class UsersController {

    @Autowired
    private UsersService usersService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    @ResponseBody ModelAndView getUsers() {
        ModelAndView modelAndView = new ModelAndView();
        List<User> userList = usersService.getAllUsers();
        modelAndView.addObject("users", userList);
        modelAndView.addObject("user", new User());
        modelAndView.setViewName("users");
        return modelAndView;
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    @ResponseBody ModelAndView addUser(@ModelAttribute("user") User user) {
        ModelAndView modelAndView = new ModelAndView();
        usersService.save(user);
        List<User> userList = usersService.getAllUsers();
        modelAndView.addObject("users", userList);
        modelAndView.setViewName("users");
        return modelAndView;
    }
}
