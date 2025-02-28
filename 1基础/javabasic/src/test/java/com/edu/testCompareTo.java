package com.edu;

import java.util.Arrays;
import java.util.Collections;
import java.util.Vector;

import org.junit.Test;

class Pair implements Comparable<Pair> {
    // int first;
    char first;
    String second;

    public Pair(char first, String second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public int compareTo(Pair o) {// 注意只能是这么实现，因为接口是int的，不能使用><否则报类型错误
        if (first != o.first) {
            return first-o.first;
        }
        return second.compareTo(o.second);
    }
}

public class testCompareTo {
    @Test
    public void testMySortCompareTo() {
        Pair s1 = new Pair('1', "3");
        Pair s2 = new Pair('1', "1");
        Pair s3 = new Pair('2', "1");
        Pair s4 = new Pair('2', "2");
        Vector<Pair>arr=new Vector<>();
        arr.add(s1);
        arr.add(s2);
        arr.add(s3);
        arr.add(s4);
        arr.forEach((p)->{
            System.out.println(p.first+" "+p.second);
        });
        System.out.println("After Sort");
        Collections.sort(arr);//注意这里只能使用Collections的方法，因为Arrays是专用与数组的！
        arr.forEach((p)->{
            System.out.println(p.first+" "+p.second);
        });
    }

}
