public class TLABInfo {
    static int a=1;
    public static void main(String[] args) {
        // 简单的对象创建操作，触发 TLAB 分配
        Object obj = new Object();
        System.out.println("Object created: " + obj);
        System.out.println(a);
        a=2;
        System.out.println(a);
    }
}