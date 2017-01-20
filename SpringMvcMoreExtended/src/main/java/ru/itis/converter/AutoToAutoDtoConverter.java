package ru.itis.converter;


import ru.itis.dto.AutoDto;
import ru.itis.dto.UserDto;
import ru.itis.models.Auto;

public class AutoToAutoDtoConverter {

    public static AutoDto convertWithoutUser(Auto auto) {
        AutoDto autoDto = new AutoDto();
        autoDto.setId(auto.getId());
        autoDto.setModel(auto.getModel());

        return autoDto;
    }

    public static AutoDto convertWithUser(Auto auto) {
        AutoDto autoDto = new AutoDto();
        autoDto.setId(auto.getId());
        autoDto.setModel(auto.getModel());

        UserDto userDto = UserToUserDtoConverter.
                convertWithoutAutos(auto.getUser());

        autoDto.setUser(userDto);
        return autoDto;
    }
}
