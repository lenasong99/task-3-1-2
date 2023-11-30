package com.example.taskspringboot.controller;
import com.example.taskspringboot.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.taskspringboot.Model.User;

import java.util.List;

@Controller
public class MyController {
    @Autowired
    private UserService userService;
    @GetMapping("/")
    public String index() {
        return "index";
    }
    @GetMapping("/all")
    public String showAllUsers(Model model) {
        List<User> userList = userService.getAllUsers();
        model.addAttribute("allUsers", userList);
        return "all-users";
    }
    @GetMapping("/user-create")
    public String createUserForm(@ModelAttribute("user") User user) {
        return "user-create";
    }

    @PostMapping("/user-create")
    public String createUser(User user) {
        userService.saveUser(user);
        return "redirect:/all";
    }

    @GetMapping("/edit-user")
    public String updateUserForm(@RequestParam("id") int id, Model model) {
       User user = userService.getUser(id);
       model.addAttribute("user", user);
        return "/edit-user";
    }
    @PostMapping("/edit-user")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.mergeUser(user);
        return "redirect:/all";
    }

    @RequestMapping("/delete-user")
    public String deleteUser(@RequestParam("id") int id) {
        userService.deleteUser(id);
        return "redirect:/all";
    }


}
