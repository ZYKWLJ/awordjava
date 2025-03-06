import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class ZeroCopy {
    public static void main(String[] args) {
        // test transferTo()
        try (FileInputStream fileInputStream = new FileInputStream("src.txt")) {
            FileOutputStream fileOutputStream = new FileOutputStream("dst.txt");
            FileChannel Ichannel = fileInputStream.getChannel();
            FileChannel Ochannel = fileOutputStream.getChannel();
            // Ichannel.transferTo(0, Ichannel.size(), Ochannel);//写往某个内存区域（磁盘IO）
            Ochannel.transferFrom(Ichannel, 0, Ichannel.size());//从某个内存区域读取(磁盘IO)
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
