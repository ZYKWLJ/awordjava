package com.mybatis.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.mybatis.mybatis.Utils.MyBatisUtils;
import com.mybatis.mybatis.entity.User;
import com.mybatis.mybatis.mapper.UserMapper;

import java.util.List;

/**
 * @author : cunyu
 * @version : 1.0
 * @className : UserDaoTest
 * @date : 2020/7/14 13:52
 * @description : UserDao 接口测试
 */

public class MybatisApplicationTest {
    @Test
    public void test(){
        // 获取 SqlSession 对象
        SqlSession sqlSession = MyBatisUtils.getSession();

        // 执行 SQL 语句
        User mapper = (User) sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getUser();

        for (User user:userList) {
            System.out.println(user);
        }

        // 关闭 SqlSession
        sqlSession.close();
    }
}
