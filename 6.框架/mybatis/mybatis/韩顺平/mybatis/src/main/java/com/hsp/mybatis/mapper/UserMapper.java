package com.hsp.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.hsp.mybatis.entity.User;

@Mapper
public interface UserMapper {
  int insertUser(User user);

  User getByUserNameAndPassword(User user);
}
