package com.edu;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.zip.CheckedOutputStream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class test4FunctionInterfaces {
    //表示一个接受类型为 T 的参数，不返回任何结果的操作，用于对输入的数据进行消费处理
    @Test
    public void testConsumer(){
        Consumer<String> consumer=(String str)->{
            System.out.println("I have accepted "+str+"!");
        };
        List<String> names = Arrays.asList("Alice", "Jack", "Joe");
        forEach(consumer,names);
    }

    private void forEach(Consumer<String> consumer, List<String> names) {
        for (String name : names) {
            consumer.accept(name);
        }
    }

    //表示一个不接受任何参数，但返回一个类型为 T 的结果的函数，用于提供数据
    @Test
    public void testSupplier() {
        // 定义一个 Supplier，用于提供当前时间的字符串表示
        Supplier<String> timeSupplier = () -> java.time.LocalTime.now().toString();
        // 使用 Supplier 获取当前时间
        String currentTime = timeSupplier.get();
        System.out.println("当前时间: " + currentTime);
    }

    //表示一个将类型为 T 的输入转换为类型为 R 的输出的函数，用于对输入数据进行转换操作
    @Test
    public void testFunction() {
        Function<String[],Character[]> function=(String[] str)->{
            //取出每一个字串的第一个字符，完成string[]->Character[]
            Character[] charArray=new Character[str.length];
            int i=0;
            for (String s : str) {
                charArray[i++]=s.charAt(0);
            }
            return charArray;
        };
        String[] str={"123","abc","ABC",",./"};
        Character[] characters = function.apply(str);
        System.out.println(Arrays.toString(characters));
    }
    //表示一个布尔值函数，接收一个类型为 T 的参数，返回一个布尔值，常用于**对输入的数据进行条件判断**
    @Test
    public void  testPredicate(){
        Predicate<String[]> predicate=(String[] str)->{
            //这里判断字符串数组第二个元素是不是数字
            boolean f=true;
            for (String s : str) {
                f&=Character.isDigit(s.charAt(1));
            }
            return f;
        };
        String[] strings={"122","aa23"};
        System.out.println(predicate.test(strings));
    }
}