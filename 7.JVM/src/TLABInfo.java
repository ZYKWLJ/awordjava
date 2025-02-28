public class TLABInfo {
    public static void main(String[] args) {
        // 简单的对象创建操作，触发 TLAB 分配
        Object obj = new Object();
        System.out.println("Object created: " + obj);
    }
}