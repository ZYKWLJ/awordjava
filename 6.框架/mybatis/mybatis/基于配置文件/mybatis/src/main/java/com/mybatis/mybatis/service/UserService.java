package com.mybatis.mybatis.service;

import com.mybatis.mybatis.entity.User;

import java.util.List;

import org.springframework.stereotype.Service;
@Service
public interface UserService {
    List<User> findAll();
    User findById(Long id);
    void insert(User user);
    void update(User user);
    void delete(Long id);
}