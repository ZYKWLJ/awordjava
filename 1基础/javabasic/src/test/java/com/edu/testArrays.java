package com.edu;

import java.sql.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Test;
// 全部是静态方法！
public class testArrays {
    @Test
    public void testArrays(){
        // test toString()
        int[] arr={3,2,5,4,1,6,7,8,9,0};
        System.out.println(Arrays.toString(arr));//转化为String类型是Arrays的静态方法！
        // test equals
        int[] arr1={3,2,5,4,1,6,7,8,9,0};
        System.out.println(arr==arr1);
        System.out.println(arr.equals(arr1));
        System.out.println(Arrays.equals(arr, arr1));
        //这里证明了必须使用Arrays.equals专用的相等方法，否则会出错！
        // test stream
        int sum = Arrays.stream(arr).sum();
        System.out.println("sum of arr equals to "+sum);
        Arrays.stream(arr1).forEach((i)->System.out.print(i+", "));
        System.out.println();
        // test sort
        // 正序
        Arrays.sort(arr1);
        System.out.println(Arrays.toString(arr1));
        // 倒序=>基本类型使用倒序必须使用相应的复合类型完成流的操作！
        // 这里也记住基本类型转化为符合类型的方式！
        Integer[] array = Arrays.stream(arr1).boxed().toArray(Integer[]::new);
        Arrays.sort(array, Comparator.reverseOrder());
        System.out.println(Arrays.toString(array));
        //要使用这个接口倒序，必须实现这个方法，但是基本类型无法实现，所以要转化成对应复合类型！
    }
}
