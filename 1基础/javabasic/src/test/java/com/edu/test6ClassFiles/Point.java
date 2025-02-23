package com.edu.test6ClassFiles;

//这是一种简便的实现不可变数据的方式！
public record Point(int x, int y) {
    public int area(){
        return x*y;
    }
}
