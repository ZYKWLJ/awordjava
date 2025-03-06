# 阻塞与非阻塞 

**ServerSocketChannel、SocketChannel**支持两种阻塞模式： 

• 阻塞模式，遇到阻塞操作产生阻塞的时候会直接阻塞。 

• 非阻塞模式，遇到阻塞操作产生阻塞的时候会**直接返回null**。  

默认都是阻塞模式，可以**手动设置为非阻塞模式**。


```java
//准备buffer
ByteBuffer buffer = ByteBuffer.allocate(1024);
//创建服务器
ServerSocketChannel serverSocketChannel=ServerSocketChannel.open();
//设置为非阻塞模式
//serverSocketChannel.configureBlocking(false);
//绑定监听端口
serverSocketChannel.bind(new InetSocketAddress(8080));
//获取连接,这是一步阻塞操作，阻塞模式下，没读到连接会在这一步阻塞；非阻塞模式下不会阻塞，会直接返回一个null
SocketChannel socketChannel = serverSocketChannel.accept();
//设置为非阻塞模式
//socketChannel.configureBlocking(false);
//读数据,这是一步阻塞操作
if(socketChannel!=null) {
   //阻塞模式下，没读到连接会在这一步阻塞；非阻塞模式下不会阻塞，会直接返回一个null
   socketChannel.read(buffer);
}
```


