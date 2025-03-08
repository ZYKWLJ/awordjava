package com.jdbc.jdbc.serviceImpl;

import com.jdbc.jdbc.entity.User;

import java.util.List;

public interface UserServiceImpl {
    // 获取所有用户
    List<User> getAllUsers();

    // 插入用户
    int insertUser(User user);
}