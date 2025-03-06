package NIO.Selector;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception{
        // 获取通道
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9999));
        // 切换成非阻塞模式
        socketChannel.configureBlocking(false);
        // 分配缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        // 发送数据
        Scanner scanner = new Scanner(System.in);
        // scanner.close();
        while (true) {
            String msg = scanner.nextLine();
            byteBuffer.put(msg.getBytes());
            byteBuffer.flip();
            socketChannel.write(byteBuffer);
            byteBuffer.clear();
        }

    }
}
