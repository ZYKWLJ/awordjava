package com.hsp.mybatis.service;

import org.springframework.stereotype.Service;

import com.hsp.mybatis.entity.User;
import com.hsp.mybatis.mapper.UserMapper;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserService {
  @Autowired
  UserMapper userMapper;

  public int insertUser(User user) {
    return userMapper.insertUser(user);
  }

  public User getByUserNameAndPassword(User user) {
    return userMapper.getByUserNameAndPassword(user);
  }
}
