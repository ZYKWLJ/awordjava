package com.spring.声明式事务.使用;
// import com.spring.声明式事务.使用.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainApplication implements CommandLineRunner {

    @Autowired
    private UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        try {
            userService.createTwoUsers();
        } catch (Exception e) {
            System.out.println("事务因异常回滚: " + e.getMessage());
        }
    }
}