package com.edu.testTransient;

import java.io.Serializable;

public class UserTransient implements Serializable{
   String name;
   transient String  password;
   transient int[] arr=new int[100000]; 
    public UserTransient(String name, String password) {
        this.name = name;
        this.password = password;
    }
    public String getName() {
        return name;
    }
    public String getPassword() {
        return password;
    }
}
