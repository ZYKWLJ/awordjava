package com.spring.声明式事务.使用;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void createTwoUsers() {
        User user1 = new User("User11");
        userRepository.save(user1);

        // 模拟异常
        int result = 1 / 0;

        User user2 = new User("User12");
        userRepository.save(user2);
    }
}