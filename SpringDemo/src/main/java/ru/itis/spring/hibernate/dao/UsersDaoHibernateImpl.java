package ru.itis.spring.hibernate.dao;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.itis.spring.hibernate.models.User;

import java.util.List;

public class UsersDaoHibernateImpl implements UsersDao {

    private SessionFactory sessionFactory;

    public UsersDaoHibernateImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<User> findAll() {
        Session session = getSession();
        session.beginTransaction();
        List<User> result =  session.createQuery("from User", User.class).list();
        session.getTransaction().commit();
        return result;
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
