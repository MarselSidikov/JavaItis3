package ru.itis.converter;


import ru.itis.dto.AutoDto;
import ru.itis.dto.UserDto;
import ru.itis.models.Auto;
import ru.itis.models.User;

import java.util.ArrayList;

public class UserToUserDtoConverter {
    public static UserDto convertWithoutAutos(User user) {

        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setAge(user.getAge());
        userDto.setName(user.getName());

        return userDto;
    }

    public static UserDto convertWithAutos(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setAge(user.getAge());
        userDto.setName(user.getName());

        userDto.setAutoDto(new ArrayList<AutoDto>());

        for (Auto auto: user.getAutos()) {
            AutoDto autoDto = AutoToAutoDtoConverter.convertWithoutUser(auto);
            userDto.getAutoDto().add(autoDto);
        }

        return userDto;
    }
}
