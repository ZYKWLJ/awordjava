package com.example.restservice;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
    public static final AtomicLong ID=new AtomicLong(0);
    public static final String formatString="hello, %s!";
    @GetMapping("/greet")
    public Greeting greet(@RequestParam(value = "name",defaultValue = "default_return")String name){
        return new Greeting(ID.incrementAndGet(),String.format(formatString, name));
    }
}
