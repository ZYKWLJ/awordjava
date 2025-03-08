package com.jdbc.jdbc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdbc.jdbc.entity.User;
import com.jdbc.jdbc.service.UserService;

@RestController
@RequestMapping("/users")
public class UserControl {
    @Autowired
    private UserService userService;
    @GetMapping
    public List<User> getUsers(){
        return userService.getAllUsers();
    }
    @PostMapping
    public int insertUser(@RequestBody User user){
        return userService.insertUser(user);
    }
}                       
