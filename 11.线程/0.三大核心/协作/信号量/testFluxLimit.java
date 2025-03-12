import java.util.concurrent.Semaphore;

public class testFluxLimit {
    public static void main(final String[] args) {
        final Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(
                            Thread.currentThread().getName() + "获得资源量，执行任务....剩余资源量:" + semaphore.availablePermits());
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + "释放资源量，给其他线程使用....剩余资源量:"+ semaphore.availablePermits());
                    semaphore.release();
                } catch (Exception e) {
                    e.printStackTrace();
                } 
            }).start();
        }
    }
}
