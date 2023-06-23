package com.example.mvc.controller;

import com.example.mvc.model.UserModel;
import com.example.mvc.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/user")
public class RestController {

    private final UserService userService;

    public RestController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user/save")
    public void saveUser(@RequestBody UserModel user) {
        userService.saveUser(user);
    }
}
