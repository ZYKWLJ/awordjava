# 一、函数式接口
```java
@FunctionalInterface
public interface Comparator<T> {
    int compare(T o1, T o2);
}
```
## 唯一方法compare(T o1, T o2);

用于比较**两个对象之间**的大小关系，需要重写！

```java
List list = List.of(1, 3, 4, 6, 7, 2, 0);
list.stream().sorted(Comparator.naturalOrder()).forEach((i) -> System.out.print(i + " "));//用于流排序
```

```java

```