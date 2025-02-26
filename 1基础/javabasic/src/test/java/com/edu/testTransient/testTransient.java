package com.edu.testTransient;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.Test;

public class testTransient {
    @Test
    public void test() throws FileNotFoundException, IOException, ClassNotFoundException{
        User user0 = new User("jack", "123456");
        // 序列化对象
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("user0.obj"));
        objectOutputStream.writeObject(user0);
        // 反序列化对象
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("user0.obj"));
        User user1 = (User)objectInputStream.readObject();
        System.out.println(user1.toString());
        System.out.println("user.name="+user1.getName());
        System.out.println("user.password="+user1.getPassword());
    }   
}
