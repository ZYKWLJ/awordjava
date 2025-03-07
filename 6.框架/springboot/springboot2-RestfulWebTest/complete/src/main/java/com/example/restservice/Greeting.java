package com.example.restservice;
// Record简洁地表示不可变final的数据载体！JDK14推出的
// 返回响应端
public record Greeting(long id, String content) { }

// 服务端返回值：
// {
//   "id": 17,
//   "content": "Hello, World!"
// }
// 
// 这是服务器返回值形式的原因--内嵌了json格式转化的库，并默认使用之
// This application uses the Jackson JSON library to automatically marshal instances of type Greeting into JSON. 
// Jackson is included by default by the web starter.