import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class TestChannal1 {
    public static void main(String[] args) {
        try (FileOutputStream fileOutputStream = new FileOutputStream("Buffer1.txt")) {
            // 获取file类型的channal（内核通道）
            FileChannel channel = fileOutputStream.getChannel();
            // 准备好要写出的位置(即内存)
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            buffer.put("those date were wrote by kernel".getBytes());
            // 将buffer换成读模式
            buffer.flip();
            // 要使用内核写出
            channel.write(buffer);
            channel.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

