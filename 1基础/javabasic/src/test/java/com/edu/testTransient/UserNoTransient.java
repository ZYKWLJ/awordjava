package com.edu.testTransient;

import java.io.Serializable;

public class UserNoTransient implements Serializable {
    String name;
    String password;
    int[] arr = new int[100000];
    public UserNoTransient(String name, String password) {
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
