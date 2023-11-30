package com.example.taskspringboot.dao;
import com.example.taskspringboot.Model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager em;
    @Override
    public List<User> getAllUsers() {
        List<User> allUsers = em.createQuery("from User", User.class).getResultList();
        return allUsers;
    }

    @Override
    public void saveUser(User user) {
        em.persist(user);
    }

    @Override
    public void mergeUser(User user) {
        em.merge(user);
    }

    @Override
    public User getUser(Integer id) {
        User user = em.find(User.class, id);
        return user;
    }

    @Override
    public void deleteUser(Integer id) {
        em.remove(em.find(User.class, id));
    }
}
