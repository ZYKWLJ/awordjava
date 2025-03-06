
// import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class TestChannal2 {
    public static void main(String[] args) {
        try {
            // 获取文件流
            FileInputStream fileInputStream = new FileInputStream("Buffer2Channel.txt");
            // 获取file类型的内核操作区域抽象Channel
            FileChannel channel = fileInputStream.getChannel();
            // 获取内存空间抽象Buffer
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            // 由内核向内存里面写
            int i = channel.read(byteBuffer);
            System.out.println("读写个数："+i+"Byte");
            // 打印内存内容
            System.out.println(new String(byteBuffer.array()));
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
