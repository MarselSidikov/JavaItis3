package ru.itis.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.itis.models.Auto;
import ru.itis.models.User;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UsersDaoJdbcTemplateImpl implements UsersDao{

    // language=SQL
    private static final String SQL_SELECT_USER_BY_ID =
            "SELECT * FROM group_member WHERE id = ?";

    // language=SQL
    private static final String SQL_SELECT_AUTO_BY_USER =
            "SELECT * FROM autos WHERE member_id = ?";

    // language=SQL
    private static final String SQL_SELECT_ALL_USERS =
            "SELECT * FROM group_member";

    // language=SQL
    private static final String SQL_SELECT_ALL_AUTO =
            "SELECT * FROM autos";

    private JdbcTemplate template;

    private Map<Integer, User> usersMap;

    public UsersDaoJdbcTemplateImpl(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
        this.usersMap = new HashMap<Integer, User>();
    }

    private RowMapper<User> userRowMapper = new RowMapper<User>() {
        public User mapRow(ResultSet resultSet, int i) throws SQLException {
            User user = new User(resultSet.getInt("id"), resultSet.getString("name"),
                    resultSet.getInt("user_age"), new ArrayList<Auto>());
            usersMap.put(user.getId(), user);
            return user;
        }
    };

    private RowMapper<Auto> autoRowMapper = new RowMapper<Auto>() {
        public Auto mapRow(ResultSet resultSet, int i) throws SQLException {
            Auto auto = new Auto(resultSet.getInt("id"),resultSet.getString("model"), null);
            User user = usersMap.get(resultSet.getInt("member_id"));
            user.getAuto().add(auto);
            auto.setUser(user);
            return auto;
        }
    };

    public int add(User model) {
        return 0;
    }

    public User find(int id) {
        // вытащили пользователя, положили в мап
        template.queryForObject(SQL_SELECT_USER_BY_ID,
                new Object[]{id}, userRowMapper);
        // вытащили машину, положили в список машин
        template.query(SQL_SELECT_AUTO_BY_USER,
                new Object[]{id}, autoRowMapper);

        // возвращаем пользовеля
        return usersMap.get(id);
    }

    public List<User> findAll() {
        return null;
    }

    public User findAllByAge(int age) {
        return null;
    }
}
