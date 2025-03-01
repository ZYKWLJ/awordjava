package com.edu;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import org.junit.Test;

class MyComparator implements Comparator<Student>{
    @Override
    public int compare(Student o1, Student o2) {
        if(o1.sroce!=o2.sroce){
            return o1.sroce-o2.sroce;
        }else if(o1.age!=o2.age){
            return o1.age-o2.age;
        }
        return o1.name.compareTo(o2.name);
    }
}
class Student  {// 核心点，现在Student类就是可以比较得了！
    String name;
    int age;
    int sroce;

    public Student(String name, int age, int sroce) {
        this.name = name;
        this.age = age;
        this.sroce = sroce;
    }
    @Override
    public String toString() {
        return "Sroce=" + this.sroce + "\tAge=" + this.age + "\tName=" + this.name;
    }
}

public class testComparator {
    @Test
    public void test() {
        Student student1 = new Student("Alice", 21, 100);
        Student student2 = new Student("Jack", 22, 90);
        Student student3 = new Student("Mark", 20, 95);
        List<Student> list = new LinkedList<>();
        list.add(student1);
        list.add(student2);
        list.add(student3);
        System.out.println("the first time:");
        list.stream().forEach(System.out::println);
        System.out.println("the second time:");
        MyComparator myComparator = new MyComparator();
        Collections.sort(list,myComparator);// 因为这里加入了为Student定制的比较器，所以可以直接传入比较器使用了~！
        list.stream().forEach(System.out::println);
        // 那接下来需要修改比较方式，我想按照降序排列呢？简单重新传入一个比较方式就好了！这就是类外比较方式的优点
        // Comparator实现的排序比较器的最大优点——解耦！
        System.out.println("the third time:");
        Collections.sort(list,(Student s1,Student s2)->{
            if(s1.sroce!=s2.sroce){
                return s2.sroce-s1.sroce;
            }else if(s1.age!=s2.age){
                return s2.age-s1.age;
            }
            return s2.name.compareTo(s1.name);
        });
        list.stream().forEach(System.out::println);
    }
}