package ru.itis.dao;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.itis.exceptions.UserNotFoundException;
import ru.itis.models.Auto;
import ru.itis.models.User;

import javax.persistence.NoResultException;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
// @Component
public class UsersDaoImpl implements UsersDao {

    //language=SQL
    private static final String SQL_INSERT_USER =
            "INSERT INTO group_member(name, age) VALUES (:name, :age)";

    @Autowired
    private SessionFactory sessionFactory;

    private NamedParameterJdbcTemplate template;

    @Autowired
    public UsersDaoImpl(DataSource dataSource) {
        this.template = new NamedParameterJdbcTemplate(dataSource);
    }


    public List<User> findAll() {
        Session session = getSession();
        session.beginTransaction();
        // language=hql
        List<User> result =  session.createQuery("from User", User.class).list();
        session.getTransaction().commit();
        return result;
    }

    public void save(User user) {
        Map<String, Object> paramsMap = new HashMap<String, Object>();
        paramsMap.put("name", user.getName());
        paramsMap.put("age", user.getAge());
        template.update(SQL_INSERT_USER, paramsMap);
    }

    public User find(int id) {

        try {
            // language=hql
            return getSession().createQuery("from User user where user.id = :id", User.class)
                    .setParameter("id", id).getSingleResult();
        } catch (NoResultException e) {
            throw new UserNotFoundException("User with id=" + id + " not found");
        }
    }

    @Override
    public List<Auto> findAutoByUserId(Integer id) {
        Session session = getSession();
        session.beginTransaction();
        User user = find(id);
        List<Auto> autos = user.getAutos();
        session.getTransaction().rollback();
        return autos;
    }

    private Session getSession() {
        Session session;

        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }

        return session;
    }
}
