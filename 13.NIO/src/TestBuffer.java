import java.nio.ByteBuffer;

public class TestBuffer {
    public static void main(String[] args) {
        byte[] resource = "hello".getBytes();
        // 初始化
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        printCapPosLim(byteBuffer);
        // 写
        byteBuffer.put(resource);
        printCapPosLim(byteBuffer);

        // 开启读模式
        byteBuffer.flip();

        // 标记当前位置
        byteBuffer.mark();

        // 读取一个字节
        System.out.println((char) byteBuffer.get());
        printCapPosLim(byteBuffer);

        // 读取剩余全部数据
        byte[] remainingData = new byte[byteBuffer.remaining()];
        byteBuffer.get(remainingData);
        System.out.println(new String(remainingData));
        printCapPosLim(byteBuffer);

        // 回到标记点
        byteBuffer.reset();
        printCapPosLim(byteBuffer);
    }

    private static void printCapPosLim(ByteBuffer byteBuffer) {
        System.out.println("缓冲空间为:" + byteBuffer.capacity());
        System.out.println("指针指向为:" + byteBuffer.position());
        System.out.println("缓冲空间限制为:" + byteBuffer.limit());
        System.out.println();
    }
}