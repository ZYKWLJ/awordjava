package com.edu.testException;

/**
 * @Author: Ethan Yankang
 * @Program: java重拾
 * @Date: 2025-02-23 20:32
 **/
// 自定义受检异常类，继承自 Exception(继承自RuntimeException也是一样的!)
class CustomArrayIndexOutOfBoundsCheckedException extends Exception {
    public CustomArrayIndexOutOfBoundsCheckedException(String message) {
        super(message);
    }
}
