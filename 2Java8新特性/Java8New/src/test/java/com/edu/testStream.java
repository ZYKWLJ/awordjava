package com.edu;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ForkJoinPool.ManagedBlocker;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.zip.CheckedOutputStream;

/**
 * @Author: Ethan Yankang
 * @Program: awordjava
 * @Date: 2025-02-24 10:14
 **/
public class testStream {
    // 过滤元素
    @Test
    public void test1() {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        List<String> filteredNames = names.stream()
                .filter(name -> name.startsWith("A"))
                .collect(Collectors.toList());

        System.out.println(Arrays.toString(filteredNames.toArray()));
        // 结果: ["Alice"]
    }

    // 映射元素
    @Test
    public void test2() {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        List<Integer> nameLengths = names.stream()
                .map(String::length)
                .collect(Collectors.toList());

        System.out.println(Arrays.toString(nameLengths.toArray()));
        // 结果: [5, 3, 7]
    }

    // 合并流+映射
    @Test
    public void test3() {
        List<List<String>> listOfLists = Arrays.asList(
                Arrays.asList("Alice", "Bob"),
                Arrays.asList("Charlie", "David"));
        List<String> flatList = listOfLists.stream()
                .flatMap(List::stream)// 合并多个流
                .collect(Collectors.toList());// 再次完成映射(映射成List)

        System.out.println(Arrays.toString(flatList.toArray()));
        // 结果: ["Alice", "Bob", "Charlie", "David"]
    }

    // 去重
    @Test
    public void test4() {
        List<String> names = Arrays.asList("bob", "bob", "jack", "jack");
        List<String> collect = names.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println(Arrays.toString(collect.toArray()));
    }

    // 自然排序
    @Test
    public void test5() {
        List<String> names = Arrays.asList("Charlie", "Alice", "Bob");
        List<String> sortedNames = names.stream()
                .sorted()
                .collect(Collectors.toList());

        System.out.println(Arrays.toString(sortedNames.toArray()));
        // 结果: ["Alice", "Bob", "Charlie"]
    }

    // 可以自定义排序规则
    @Test
    public void test6() {
        System.out.println("Running test6...");
        List<String> names = Arrays.asList("Charlie", "Aalice", "Bbob");
        List<String> sortedNames = names.stream()
                .sorted(Comparator.comparing(s -> s.length() > 1 ? s.charAt(1) : '\0', Comparator.reverseOrder()))
                .collect(Collectors.toList());
        // 结果: ["Charlie", "Bob", "Alice"]
        System.out.println(Arrays.toString(sortedNames.toArray()));
    }

    // 仅仅取出元素来操作，但不改变流内容
    @Test
    public void test7() {
        List<String> names = Arrays.asList("Charlie", "Alice", "Bob");
        names.stream()
                .peek(System.out::println)
                .collect(Collectors.toList());
        // 结果: ["Charlie", "Bob", "Alice"]
        // System.out.println(Arrays.toString(sortedNames.toArray()));
    }

    @Test
    public void test8() {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        names.stream().forEach(System.out::println);
        // 输出: Alice, Bob, Charlie
    }

    @Test
    public void test9() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        var sum = numbers.stream()
                .reduce(Integer::sum);
        sum.ifPresent(System.out::println);
        // 结果: Optional[10]
    }

    // 收集
    @Test
    public void test10() {
        var names = Arrays.asList("jack", "mark", "Alice", "Joe");
        var map = names.stream()
                .collect(Collectors.toMap(name -> name, name -> name.length()));// 名字作为键，长度作为值

        map.forEach((name, length) -> System.out.println(name + ": " + length));
    }

    // 计数元素
    @Test
    public void test11() {
        var names = Arrays.asList("jack", "mark", "Alice", "Joe");
        long count = names.stream().count();
        System.out.println(count);
    }

    // 是否有一个满足
    @Test
    public void test12() {
        var names = Arrays.asList("jack", "mark", "Alice", "Joe");
        var f = names.stream().anyMatch(name -> (name.length() == 5));
        System.out.println(f);
    }

    // 是不是全部满足
    @Test
    public void test13() {
        var names = Arrays.asList("Alice", "ABC", "CBA", "aaa");
        var f = names.stream().allMatch(name -> (name.startsWith("A") || name.endsWith("A")));
        System.out.println(f ? "All names startWith A or endWith A" : "No");
    }

    // 截取前n个元素
    @Test
    public void test14() {
        var names = Arrays.asList("Alice", "ABC", "CBA", "aaa");
        List<String> collect = names.stream().limit(3).collect(Collectors.toList());
        collect.forEach(System.out::println);
    }

    // 跳过前n个元素
    @Test
    public void test15() {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        List<String> skippedNames = names.stream()
                .skip(1)
                .collect(Collectors.toList());
        skippedNames.forEach(System.out::println);
        // 结果: ["Bob", "Charlie"]
    }

    // 无限流截取操作
    @Test
    public void test16() {
        Stream<Integer> stream = Stream.iterate(2, n -> n + 1);
        var s = stream.limit(50).collect(Collectors.toList());
        s.forEach(System.out::println);
    }

    // 元素映射，返回每一个元素的长度！
    @Test
    public void test17() {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        IntStream mapToInt = names.stream().mapToInt(String::length);
        mapToInt.forEach(System.out::println);
    }

    // 合并两个流
    @Test
    public void test18() {
        Stream<String> stream1 = Stream.of("Alice", "Bob");
        Stream<String> stream2 = Stream.of("Charlie", "David");
        Stream<String> combinedStream = Stream.concat(stream1, stream2);
        List<String> names = combinedStream.collect(Collectors.toList());
        names.forEach(System.out::println);
        // 结果: ["Alice", "Bob", "Charlie", "David"]
    }

    // 按自定义规则获取最大值
    @Test
    public void test19() {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "ABCDEFG");
        Optional<String> max = names.stream().max(Comparator.comparingInt(String::length));
        // System.out.println(max);
        max.ifPresent(System.out::println);
    }

    // 将流转化为数组
    @Test
    public void test20() {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "ABCDEFG");
        Object[] array = names.stream().toArray();
        for (Object s : array) {
            System.out.println(s);
        }
    }
}
