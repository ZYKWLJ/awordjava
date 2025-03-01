# 一、必须在类外部新建一个基于该类型的Comparator的实现类比较器，让比较方式解耦，性能更好！

Comparator可以认为是是一个外比较器，个人认为有两种情况可以使用实现Comparator接口的方式：
1、一个对象**不支持自己和自己比较（没有实现Comparable接口）**，但是又想对两个对象进行比较
2、一个对象实现了Comparable接口，但是开发者认为**compareTo方法中的比较方式并不是自己想要的那种比较方式**


# 二、函数式接口——唯一方法compare(T o1, T o2);
```java
@FunctionalInterface
public interface Comparator<T> {
    int compare(T o1, T o2);
}
```
用于比较**两个对象之间**的大小关系，需要重写！
compare(o1,o2)
1、o1大于o2，返回正整数
2、o1等于o2，返回0
3、o1小于o3，返回负整数

# 三、示例代码

```java
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
        // 如果是Comparable的话，还需要修改类！所以不好！
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
```