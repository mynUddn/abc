package com.example.mvc.controller;

import com.example.mvc.model.UserModel;
import com.example.mvc.service.UserService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {

    private final UserService userService;

    public Controller(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String showHome(){
        return "index";
    }

    @GetMapping("/users")
    public String usersList(Model model){
        List<UserModel> usersList = userService.getUser();
        model.addAttribute("usersList", usersList);
        return "users";
    }

    @GetMapping("/users/new")
    public String addNew(Model model){
        model.addAttribute("user", new UserModel());

        return "add_form";
    }

    @PostMapping("/users/save")
    public String saveUser(UserModel user){
    userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/users/edit{id}")
    public String editUser(@PathVariable("id") Integer id, Model model){
        UserModel user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "add_form";
    }

    @GetMapping("/users/delete{id}")
    public String deleteUser(@PathVariable ("id") Integer id){
        userService.deleteUserById(id);

        return "redirect:/users";
    }
}
