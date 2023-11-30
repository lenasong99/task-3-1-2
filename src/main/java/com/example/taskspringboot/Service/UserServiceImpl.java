package com.example.taskspringboot.Service;
import com.example.taskspringboot.Model.User;
import com.example.taskspringboot.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        userDao.saveUser(user);
    }
    @Override
    @Transactional
    public void mergeUser(User user) {
        userDao.mergeUser(user);
    }

    @Override
    @Transactional
    public void deleteUser(Integer id) {
        userDao.deleteUser(id);
    }

    @Override
    @Transactional
    public User getUser(Integer id) {
        return userDao.getUser(id);
    }
}
