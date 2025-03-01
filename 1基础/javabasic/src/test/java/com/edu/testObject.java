package com.edu;

import org.junit.Test;

public class testObject {
    @Test
    public void testAllMethod(){
        Object object = new Object();
        System.out.println(object.hashCode());
        System.out.println(Integer.toHexString(object.hashCode()) );
        System.out.println(object.toString());
        Class<Object> class1 = (Class<Object>) object.getClass();
        System.out.println(class1);
        Object object1 = new Object();
        System.out.println(object.equals(object1));
    }
}
