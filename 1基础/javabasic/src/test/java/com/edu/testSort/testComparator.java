package com.edu.testSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;
// 学生类
class Student {
    String name;
    int age;

    // 构造函数
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', age=" + age + "}";
    }
}

// 定义一个比较器来比较 Student 对象
class StudentComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        // 先按名字排名，再按照年龄排名
        if (!o1.name.equals(o2.name)) {
            return o1.name.compareTo(o2.name);
        }
        return o1.age - o2.age;
    }
}

// 学生基本信息 + 分数类
class Pair {
    Student student;
    int score;

    // 构造函数
    public Pair(Student student, int score) {
        this.student = student;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Pair{student=" + student + ", score=" + score + "}";
    }
}

// 定义一个比较器来比较 Pair 对象
class PairComparator implements Comparator<Pair> {
    @Override
    public int compare(Pair o1, Pair o2) {
        // 使用 StudentComparator 比较学生信息
        StudentComparator studentComparator = new StudentComparator();
        int studentCompare = studentComparator.compare(o1.student, o2.student);
        if (studentCompare != 0) {
            return studentCompare;
        }
        // 若学生信息相同，则比较分数
        return o1.score - o2.score;
    }
}

public class testComparator {
    @Test
    public void testComparatorNaturalOrReverseOrder() {
        List list = List.of(1, 3, 4, 6, 7, 2, 0);
        list.stream().sorted(Comparator.naturalOrder()).forEach((i) -> System.out.print(i + " "));
        var list1 = list;
        System.out.println();
        list1.stream().sorted(Comparator.reverseOrder()).forEach((i) -> System.out.print(i + " "));
    }

    @Test
    public void testCompareTo() {
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
        // 创建 PairComparator 实例
        PairComparator pairComparator = new PairComparator();
        // 使用 Collections.sort 方法结合 PairComparator 对列表进行排序
        Collections.sort(pairList, pairComparator);

        // 输出排序后的结果
        for (Pair pair : pairList) {
            System.out.println(pair);
        }

    }
}
