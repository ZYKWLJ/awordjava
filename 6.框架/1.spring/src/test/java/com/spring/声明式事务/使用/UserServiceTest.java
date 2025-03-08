// package com.spring.声明式事务.使用;
// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.SpringBootConfiguration;
// import org.springframework.boot.test.context.SpringBootTest;
// // import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.transaction.annotation.Transactional;

// import static org.junit.jupiter.api.Assertions.assertEquals;

// @SpringBootTest(classes = com.spring.声明式事务.使用.Main.class)
// @Transactional // 测试中使用事务，测试结束后会自动回滚
// public class UserServiceTest {

//     @Autowired
//     private UserService userService;

//     @Autowired
//     private UserRepository userRepository;

//     @Test
//     public void testCreateTwoUsersWithException() {
//         try {
//             userService.createTwoUsers();
//         } catch (Exception e) {
//             // 捕获异常，因为 createTwoUsers 方法中会抛出异常
//         }

//         // 验证数据库中没有插入任何用户
//         long userCount = userRepository.count();
//         assertEquals(0, userCount);
//     }
// }