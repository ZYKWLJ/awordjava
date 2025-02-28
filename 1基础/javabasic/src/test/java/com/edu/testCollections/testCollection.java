package com.edu.testCollections;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import org.junit.Test;

public class testCollection {
    Queue<Integer>queue=new LinkedList<>();
    Map<Integer,Integer>map=new HashMap<>();
    Map<Integer,Integer>map1=new Hashtable<>();
    
   @Test
   public void testHashSet(){

   }
   @Test
   public void testHashMap(){
        map1.put(1, 1);
        map1.forEach((k,v)->System.out.println(k+" "+v));
   }
}
