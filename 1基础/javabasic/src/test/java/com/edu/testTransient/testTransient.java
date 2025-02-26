package com.edu.testTransient;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.Test;

public class testTransient {
    UserNoTransient userNoTransient = new UserNoTransient("jack", "123456");
    UserTransient userTransient=new UserTransient("jack","123456");

    @Test
    public void test() throws FileNotFoundException, ClassNotFoundException, IOException {
        NoTransient(userNoTransient);
        System.out.println();
        Transient(userTransient);
    }

    public void NoTransient(UserNoTransient userNoTransient) throws FileNotFoundException, IOException, ClassNotFoundException {
        // 序列化对象
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("user.obj"));
        objectOutputStream.writeObject(userNoTransient);
        // 获取序列化文件的大小
        File fileWithoutTransient = new File("user.obj");
        // 序列化文件的长度
        long TransientSize = fileWithoutTransient.length();
        System.out.println("Serializable file size No Transient = " + TransientSize + " Bytes");
        // 反序列化对象
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("user.obj"));
        UserNoTransient user = (UserNoTransient) objectInputStream.readObject();
        System.out.println(user.toString());
        System.out.println("user.name=" + user.getName());
        System.out.println("user.password=" + user.getPassword());
    }

    public void Transient(UserTransient userTransient) throws FileNotFoundException, IOException, ClassNotFoundException {
        // 序列化对象
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("user.obj"));
        objectOutputStream.writeObject(userTransient);
        // 获取序列化文件的大小
        File fileWithoutTransient = new File("user.obj");
        // 序列化文件的长度
        long TransientSize = fileWithoutTransient.length();
        System.out.println("Serializable file size Transient = " + TransientSize + " Bytes");
        // 反序列化对象
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("user.obj"));
        UserTransient user = (UserTransient) objectInputStream.readObject();
        System.out.println(user.toString());
        System.out.println("user.name=" + user.getName());
        System.out.println("user.password=" + user.getPassword());
    }
}
