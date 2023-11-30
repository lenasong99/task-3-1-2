package com.example.taskspringboot.dao;
import java.util.List;
import com.example.taskspringboot.Model.User;
public interface UserDao {
    public List<User> getAllUsers();

    public void saveUser(User user);
    public void mergeUser(User user);

    public User getUser(Integer id);

    public void deleteUser(Integer id);
}
