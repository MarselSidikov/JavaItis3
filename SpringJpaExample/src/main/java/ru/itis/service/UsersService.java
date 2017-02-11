package ru.itis.service;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.dao.UsersRepository;
import ru.itis.models.Auto;
import ru.itis.models.User;

import java.util.List;

@Service
@Transactional
public class UsersService {

    @Autowired
    UsersRepository usersRepository;

    public void showUsers() {
        List<User> users = Lists.newArrayList(usersRepository.findAll());

        for (User user : users) {
            System.out.println(user.getName());
        }

        System.out.println(users.get(0).getAutos().get(1).getModel());

        User user = usersRepository.findByAge(12).get(2);

        System.out.println(user.getName());

        List<User> users2 = usersRepository.findUpperAge(12);

        for (User user2 : users2) {
            System.out.println(user2.getName() +  " " + user2.getAge());
        }
    }
}
