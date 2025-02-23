package com.edu.testReflect;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

/**
 * @Author: Ethan Yankang
 * @Program: java重拾
 * @Date: 2025-02-23 18:26
 **/
//这个类测试Class对象的通过方法可以拥有的类的那些信息！
public class testReflectMethod {
    @Test
    public void test() throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Student student=new Student(20,"Alice");
        Class<Student> clazz = Student.class;
        //studentClass.
        System.out.println("反射返回类的总体信息:\n");
        System.out.println("使用反射返回类的全限名:");
        System.out.println(clazz.getName());
        System.out.println("使用反射返回类名:");
        System.out.println(clazz.getSimpleName());
        System.out.println("使用反射返回类的规范名称:");
        System.out.println(clazz.getCanonicalName());
        System.out.println("使用反射返回类的全限名:");
        System.out.println(clazz.getName());

        System.out.println();
        System.out.println("反射创建类实例:\n");
        System.out.println("Java9之前:\n");
        Student student1 = clazz.newInstance();
        System.out.println(student1);
        Constructor<Student> constructor = clazz.getConstructor(int.class, String.class);
        System.out.println("Java9之后建议使用构造方法调用，可以带参:\n");
        Student student2 = constructor.newInstance(11, "Jack");
        System.out.println(student2);

        System.out.println();
        System.out.println("反射访问类成员(这个只返回public的):\n");
        System.out.println(Arrays.toString(clazz.getFields()));
        System.out.println("反射访问类方法:\n");
        System.out.println(Arrays.toString(clazz.getMethods()));
        System.out.println("反射访问类注解:\n");
        System.out.println(Arrays.toString(clazz.getDeclaredAnnotations()));
        System.out.println("反射访问类加载器:\n");
        System.out.println(clazz.getClassLoader());

    }
}
