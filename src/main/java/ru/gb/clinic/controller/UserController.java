package ru.gb.clinic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.gb.clinic.model.User;
import ru.gb.clinic.service.UserService;

import java.util.List;

@Controller
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public String getUsers(Model model) {
        List<User> userList = userService.getUsers();
        model.addAttribute("users", userList);
        return "users";
    }

    @GetMapping("/add")
    public String addUser(Model model) {
        return "add-user";
    }

    @PostMapping("/save")
    public String saveUser(User user, Model model) {
        userService.saveUser(user);
        return "users";
    }
}
