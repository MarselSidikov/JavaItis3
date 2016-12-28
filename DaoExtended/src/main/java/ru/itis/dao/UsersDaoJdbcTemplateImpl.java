package ru.itis.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.itis.models.User;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UsersDaoJdbcTemplateImpl implements UsersDao{

    // language=SQL
    private static final String SQL_SELECT_USER_BY_ID =
            "SELECT * FROM group_member WHERE id = ?";

    private JdbcTemplate template;

    public UsersDaoJdbcTemplateImpl(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }

    private RowMapper<User> userRowMapper = new RowMapper<User>() {
        public User mapRow(ResultSet resultSet, int i) throws SQLException {
            return new User(resultSet.getInt("id"), resultSet.getString("name"), 0, null);
        }
    };

    public int add(User model) {
        return 0;
    }

    public User find(int id) {
        return template.queryForObject(SQL_SELECT_USER_BY_ID,
                new Object[]{id}, userRowMapper);
    }

    public List<User> findAll() {
        return null;
    }

    public User findAllByAge(int age) {
        return null;
    }
}
