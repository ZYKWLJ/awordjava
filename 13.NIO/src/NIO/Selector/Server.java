package NIO.Selector;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class Server {
    public static void main(String[] args) throws Exception{
        // 获取通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        // 切换为非阻塞模式
        serverSocketChannel.configureBlocking(false);
        // 绑定连接的端口
        serverSocketChannel.bind(new InetSocketAddress(9999));
        // 获取选择器
        Selector selector = Selector.open();
        // 将通道注册到选择器上，并开始指定监听接收事件 
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        // 轮询监听
        while (selector.select() > 0) {
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();
                // 判当前socket的事件
                // 1.接收事件（表示socket接收到了数据）
                if (selectionKey.isAcceptable()) {
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    // 切换为非阻塞模式
                    socketChannel.configureBlocking(false);
                    // 将通道以读就绪的事件重新注册到选择器
                    socketChannel.register(selector, SelectionKey.OP_READ);
                }
                // 2.读就绪事件
                if (selectionKey.isReadable()) {
                    SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                    // 读取数据
                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                    int length = 0;
                    while ((length = socketChannel.read(byteBuffer)) > 0) {
                        byteBuffer.flip();
                        System.out.println(new String(byteBuffer.array(), 0, length));
                        byteBuffer.clear();
                    }
                }
                // 事件处理完成，移除事件
                iterator.remove();
            }
        }
    }
}
