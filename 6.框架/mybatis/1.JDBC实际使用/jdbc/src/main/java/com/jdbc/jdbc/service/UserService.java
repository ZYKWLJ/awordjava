package com.jdbc.jdbc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdbc.jdbc.dao.UserDao;
import com.jdbc.jdbc.entity.User;
import com.jdbc.jdbc.serviceImpl.UserServiceImpl;

@Service
public class UserService implements UserServiceImpl{
    @Autowired
    private UserDao userDao;
    @Override
    public List<User> getAllUsers(){
        return userDao.getAllUsers();
    }
    @Override
    public int insertUser(User user){
        return userDao.insertUser(user);
    }
}
