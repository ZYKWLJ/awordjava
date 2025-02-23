package com.edu.testException;

public class CustomCheckedExceptionExample {
    public static int getArrayElement(int[] array, int index) throws CustomArrayIndexOutOfBoundsCheckedException {
        // 检查索引是否越界
        if (index < 0 || index >= array.length) {
            throw new CustomArrayIndexOutOfBoundsCheckedException("数组索引越界，索引: " + index);
        }
        return array[index];
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3};
        try {
            int element = getArrayElement(array, 5);
            System.out.println("获取到的元素: " + element);
        } catch (CustomArrayIndexOutOfBoundsCheckedException e) {
            System.out.println("捕获到自定义受检异常: " + e.getMessage());
        }
    }
}