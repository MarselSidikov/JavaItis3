package ru.itis.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import org.springframework.data.repository.query.Param;
import ru.itis.models.User;

import java.util.List;

public interface UsersRepository extends CrudRepository<User, Integer> {

    List<User> findByAge(Integer age);

    @Query(value = "select user from User user where user.age > :age")
    List<User> findUpperAge(@Param("age") Integer age);
}
