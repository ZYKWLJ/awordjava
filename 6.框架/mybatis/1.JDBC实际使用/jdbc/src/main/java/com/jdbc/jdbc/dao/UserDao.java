package com.jdbc.jdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jdbc.jdbc.entity.User;
@Repository
public class UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public List<User> getAllUsers(){
        String sql="select * from `user`";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
    }

    public int insertUser(User user){
        String sql="INSERT INTO `user` (id, name) VALUES (?, ?)";
        return jdbcTemplate.update(sql, user.getId(),user.getName());
    }
}
