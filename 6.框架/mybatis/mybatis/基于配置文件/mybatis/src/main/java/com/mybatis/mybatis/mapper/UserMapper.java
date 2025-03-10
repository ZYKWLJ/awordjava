package com.mybatis.mybatis.mapper;

import com.mybatis.mybatis.entity.User;
// import org.apache.ibatis.annotations.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    List<User> findAll();
    User findById(Long id);
    void insert(User user);
    void update(User user);
    void delete(Long id);
}