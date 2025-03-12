import java.util.concurrent.Semaphore;

public class testMutex {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "获得锁.....,开始访问资源");
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + "释放锁.....,其他线程可以访问资源");

                    semaphore.release();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
