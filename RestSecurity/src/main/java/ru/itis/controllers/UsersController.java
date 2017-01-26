package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itis.dto.UserDataForRegistrationDto;
import ru.itis.dto.UserDto;
import ru.itis.model.User;
import ru.itis.service.UsersService;

import java.util.List;

/**
 * 25.01.17
 * UsersController
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@RestController
public class UsersController {

    @Autowired
    private UsersService usersService;

    @PostMapping("/users")
    public ResponseEntity<UserDto> signUp(@RequestBody UserDataForRegistrationDto user) {
        return new ResponseEntity<>(usersService.registerUser(user), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestHeader("password") String password,
                                         @RequestHeader("login") String login) {
        String token = usersService.login(password, login);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Auth-Token", token);
        return new ResponseEntity<>(null, headers, HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        return new ResponseEntity<>(usersService.getUsers(), HttpStatus.ACCEPTED);
    }
}
