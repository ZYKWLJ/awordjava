package com.edu.testSort;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 学生类，实现 Comparable 接口
class Student implements Comparable<Student> {
    String name;
    int age;

    // 构造函数
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Student o2) {
        // 先按名字排名，再按照年龄排名
        if (!this.name.equals(o2.name)) {
            return this.name.compareTo(o2.name);
        }
        return this.age - o2.age;
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', age=" + age + "}";
    }
}

// 学生基本信息 + 分数类，实现 Comparator 接口
class Pair implements Comparable<Pair> {
    Student student;
    int score;

    // 构造函数
    public Pair(Student student, int score) {
        this.student = student;
        this.score = score;
    }

    @Override
    public int compareTo(Pair o2) {
        // 先按学生信息排名，再按照分数排名
        int studentCompare = this.student.compareTo(o2.student);
        if (studentCompare != 0) {
            return studentCompare;
        }
        return this.score - o2.score;
    }

    @Override
    public String toString() {
        return "Pair{student=" + student + ", score=" + score + "}";
    }
}

public class testComparable {
    public static void main(String[] args) {
        // 创建学生对象
        Student student1 = new Student("Alice", 20);
        Student student2 = new Student("Bob", 18);
        Student student3 = new Student("Alice", 22);

        // 创建 Pair 对象
        Pair pair1 = new Pair(student1, 80);
        Pair pair2 = new Pair(student2, 90);
        Pair pair3 = new Pair(student3, 70);

        // 将 Pair 对象添加到列表中
        List<Pair> pairList = new ArrayList<>();
        pairList.add(pair1);
        pairList.add(pair2);
        pairList.add(pair3);

        // 对列表进行排序
        Collections.sort(pairList);

        // 输出排序后的结果
        for (Pair pair : pairList) {
            System.out.println(pair);
        }
    }
}
