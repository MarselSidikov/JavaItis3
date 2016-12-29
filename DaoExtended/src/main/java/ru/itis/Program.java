package ru.itis;

import ru.itis.factories.ServiceFactory;
import ru.itis.models.User;
import ru.itis.service.UsersService;

public class Program {
    public static void main(String[] args) {
        UsersService service = ServiceFactory.getInstance().getUsersService();

        User user = service.getUser(1);
    }
}
