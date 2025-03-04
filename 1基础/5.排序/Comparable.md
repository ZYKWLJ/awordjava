# 一、核心：在一个类内部自定义该类的比较方法
也即实现了这个接口，该类就是可以comparable的了，**是可比较的了**!


# 二、函数式接口——核心方法：compareTo
源码
```java
@FunctionalInterface
public interface Comparable<T> {
    public int compareTo(T o);
}
```

## int compareTo(T o)
compareTo方法的返回值是int，有三种情况：
1、比较者大于被比较者（也就是compareTo方法里面的对象），那么返回**正整数**
2、比较者等于被比较者，那么返回0
3、比较者小于被比较者，那么返回**负整数**

---
# 三、实例
示例代码：
```java

class Student implements Comparable<Student>{//核心点，现在Student类就是可以比较得了！
    String name;
    int age;
    public Student(String name, int age, int sroce) {
        this.name = name;
        this.age = age;
        this.sroce = sroce;
    }
    int sroce;
    @Override
    public int compareTo(Student o) {//先比较分数，在比较年龄，在比较姓名
        if(this.sroce!=o.sroce){
            return -this.sroce+o.sroce;
        }else if(this.age!=o.age){
            return -this.age+o.age;
        }
        return -this.name.compareTo(o.name);
    }
    @Override
    public String toString() {
        return "Sroce="+this.sroce+"\tAge="+this.age+"\tName="+this.name;
    }
    
}
public class testComparable {
    @Test
    public void test(){
        Student student1=new Student("Alice",21,100);
        Student student2=new Student("Jack",22,90);
        Student student3=new Student("Mark",20,95);
        List<Student> list=new LinkedList<>();
        list.add(student1);
        list.add(student2);
        list.add(student3);
        list.stream().forEach(System.out::println);
        Collections.sort(list);//因为Student实现了Comparable接口，是可以比较的了，直接比较！
        list.stream().forEach(System.out::println);
    }
}
```