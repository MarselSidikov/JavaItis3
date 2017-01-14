package ru.itis.spring.jdbc.dao;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import ru.itis.spring.jdbc.model.Auto;
import ru.itis.spring.jdbc.model.User;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UsersDaoJdbcImpl implements UsersDao {

    // language=sql
    private static String SQL_SELECT_USERS_WITH_AUTO =
            "SELECT * FROM group_member,autos WHERE group_member.id = " +
                    "autos.member_id ORDER BY member_id;";

    // language=sql
    private static String SQL_GET_USERS = "SELECT * FROM group_member;";
    // language=sql
    private static String SQL_GET_AUTO = "SELECT * FROM autos";

    // language=sql
    private static String SQL_GET_USER_BY_ID =
            "SELECT * FROM group_member WHERE id = :userId;";

    // language=sql
    private static String SQL_INSERT_USER =
            "INSERT INTO group_member(name) VALUES(:name);";

    // шаблон для работы с базами данных
    private NamedParameterJdbcTemplate template;

    private Map<Long, User> userMap;
    // dataSource - источник данных

    public UsersDaoJdbcImpl(DataSource dataSource) {
        template = new NamedParameterJdbcTemplate(dataSource);
        userMap = new HashMap<Long, User>();
    }

    RowMapper<User> userRowMapper = new RowMapper<User>() {
        public User mapRow(ResultSet resultSet, int i) throws SQLException {
            User user = new User(resultSet.getLong("id"), resultSet.getString("name"), new ArrayList<Auto>());
            userMap.put(user.getId(), user);
            return user;
        }
    };

    RowMapper<Auto> autoRowMapper = new RowMapper<Auto>() {
        public Auto mapRow(ResultSet resultSet, int i) throws SQLException {
            Auto auto = new Auto(resultSet.getLong("id"), resultSet.getString("model"),
                    userMap.get(resultSet.getLong("member_id")));

            userMap.get(auto.getOwner().getId()).getAutos().add(auto);
            return auto;
        }
    };

    public List<User> findAll() {
        template.query(SQL_GET_USERS, userRowMapper);
        template.query(SQL_GET_AUTO, autoRowMapper);

        return new ArrayList<User>(userMap.values());
    }

    public void save(User user) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("name", user.getName());
        template.update(SQL_INSERT_USER, params);
    }

}
