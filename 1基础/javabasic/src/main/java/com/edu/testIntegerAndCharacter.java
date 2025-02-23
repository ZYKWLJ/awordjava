package com.edu;

public class testIntegerAndCharacter {

    public static void main(String[] args) {
        System.out.println("测试各种基本数据类型及其转化:");
        testInteger();
        testCharacter();
        testString();
    }

    private static void testString() {
        System.out.println("\n测试字符串String\n");

    }

    private static void testCharacter() {
        System.out.println("\n测试字符Charter\n");
        char c1='1';
        char c2='2';
        char c3='a';
        char c4=' ';
        boolean isDigit = Character.isDigit(c1);
        boolean isAlphabetic = Character.isAlphabetic(c2);
        boolean isLetterOrDigit = Character.isLetterOrDigit(c3);
        char toUpperCase = Character.toUpperCase(c3);
        boolean isWhitespace = Character.isWhitespace(c4);
        System.out.println("测试Character.isDigit()="+isDigit);
        System.out.println("测试Character.isAlphabetic()="+isAlphabetic);
        System.out.println("测试Character.isLetterOrDigit()="+isLetterOrDigit);
        System.out.println("测试Character.istoUpperCase()="+toUpperCase);
        System.out.println("测试Character.isWhitespace()="+isWhitespace);
    }

    private static void testInteger() {
        System.out.println("\n测试整数Integer\n");
        int i1=1;
        Integer i2=2;
        String s1 = "000320000";
        int i3 = i2.intValue();
        byte i4 = i2.byteValue();
        int i5 = Integer.parseInt(s1);
        Integer i6 = Integer.valueOf(s1);
        //System.out.println(i1++Integer.toString(i6));
        System.out.println("打印数字="+i1);
        System.out.println("打印Integer的toString="+Integer.toString(i2));
        System.out.println(i3);
        System.out.println("打印Byte的toString="+Byte.toString(i4));
        System.out.println("打印将string转为int的Integer.parseInt()="+i5);
        System.out.println("打印提取string里面的值的Integer.valueOf()="+Integer.toString(i6));
        System.out.println("Integer.MAX_VALUE="+Integer.MAX_VALUE);
        System.out.println("Integer.MIN_VALUE="+Integer.MIN_VALUE);
        System.out.println("Integer的最值就是2^32两边分，因为是4字节，32位的="+Math.pow(2,31));
    }

}