package com.example.taskspringboot.Service;
import com.example.taskspringboot.Model.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();
    public User getUser(Integer id);
    public void saveUser(User user);
    public void mergeUser(User user);
    public void deleteUser(Integer id);
}
