package ru.itis.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itis.converter.AutoToAutoDtoConverter;
import ru.itis.converter.UserToUserDtoConverter;
import ru.itis.dto.AutoDto;
import ru.itis.dto.UserDto;
import ru.itis.models.Auto;
import ru.itis.models.User;
import ru.itis.service.UsersService;

import java.util.ArrayList;
import java.util.List;

// избавляет от ResponseBody
@RestController
@RequestMapping("/rest")
public class RestUsersController {

    @Autowired
    private UsersService service;

    @GetMapping(value = "/users")
    public List<UserDto> getUser() {
        List<UserDto> result = new ArrayList<>();

        List<User> users = service.getAllUsers();
        for (User user : users) {
            result.add(UserToUserDtoConverter.convertWithAutos(user));
        }
        return result;
    }

    @PostMapping(value = "/users")
    public ResponseEntity<List<UserDto>> addUser(@RequestBody UserDto userDto) {
        User user = new User();
        user.setAge(userDto.getAge());
        user.setName(userDto.getName());
        service.save(user);

        List<UserDto> result = new ArrayList<>();

        List<User> users = service.getAllUsers();
        for (User currentUser : users) {
            result.add(UserToUserDtoConverter.convertWithAutos(currentUser));
        }

        ResponseEntity<List<UserDto>> response = new
                ResponseEntity<List<UserDto>>(result, HttpStatus.CREATED);

        return response;

    }

    @GetMapping(value = "/users/{user-id}/autos")
    public List<AutoDto> getAutos(@PathVariable("user-id") int userId) {
        List<AutoDto> result = new ArrayList<>();

        List<Auto> autos = service.getAutoByUserId(userId);
        for (Auto auto : autos) {
            result.add(AutoToAutoDtoConverter.convertWithUser(auto));
        }
        return result;
    }

}
