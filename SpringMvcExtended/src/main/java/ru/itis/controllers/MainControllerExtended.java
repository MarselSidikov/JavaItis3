package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.service.UsersService;

@Controller
public class MainControllerExtended {

    @Autowired
    private UsersService service;

    @RequestMapping(value = "/welcome/{some-info}", method = RequestMethod.GET, produces = "text/html")
    @ResponseBody ModelAndView showWelcome(
            @PathVariable("some-info") String someInfo,
            @RequestParam("param") int value) {
        System.out.println(someInfo);
        System.out.println(value);
        System.out.println(service.getUser().getName());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("firstPage");
        return modelAndView;
    }
}
