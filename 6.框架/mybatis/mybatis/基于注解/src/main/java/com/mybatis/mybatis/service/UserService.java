package com.mybatis.mybatis.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mybatis.mybatis.entity.User;

@Service
public interface UserService {

    public List<User> findAll();

    public User findById(Long id) ;

    public void insert(User user) ;

    public void update(User user) ;

    public void delete(Long id) ;
}
