package Channal.file2file;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class NoZeroCopy {
    public static void main(String[] args) {
        try (// 实现非零文件拷贝，也就是分别对读写文件建立内核区，然后与在用户段交互
        FileOutputStream fileOutputStream = new FileOutputStream("dst.txt")) {
            FileInputStream fileInputStream = new FileInputStream("src.txt");
            // 获取内核段
            FileChannel Ichannel = fileInputStream.getChannel();
            FileChannel Ochannel = fileOutputStream.getChannel();
            // 分配用户段
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            // 一直读取拷贝,读到内存中放着
            while (true) {
                int i = Ichannel.read(byteBuffer);
                if(i==-1)break;
            }

            // 再从内存总读到内核
            // 开启读模式
            byteBuffer.flip();
            Ochannel.write(byteBuffer);
            System.out.println(new String(byteBuffer.array()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
