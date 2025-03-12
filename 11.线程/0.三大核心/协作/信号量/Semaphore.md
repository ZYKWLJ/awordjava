# 一、Semaphore 简介——控制线程进入临界区的数量

Semaphore是一种计数信号量，利用它可以`控制一定数量的请求`，从而`实现资源访问限制的目的`，实际应用中，可以用来限制访问某种资源的数量，比如在Hystrix中就有基于Semaphore的资源隔离策略。

最简单的理解信号量就是，`一个计数器、一个等待队列、两个方法`（在Java实现的Semaphore中就是acquire和release）。

调用一次`acquire方法，计数器就减1`，如果此时计数器`小于0，则阻塞当前线程`，否则当前线程可继续执行。

调用一次`release方法，计数器就加1`，如果此时计数器`小于等于0，则唤醒一个等待队列中的线程`，并将其中等待队列中移除。


## 常用的场景：
1.限流器

2.互斥锁

# 二、实战

## 1.限流器
```java
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
                    semaphore.release();
                    System.out.println(Thread.currentThread().getName() + "释放资源量，给其他线程使用....剩余资源量:"+ semaphore.availablePermits());
                } catch (Exception e) {
                    e.printStackTrace();
                } 
            }).start();
        }
    }
}

```
结果
```java
Thread-2获得资源量，执行任务....剩余资源量:0
Thread-1获得资源量，执行任务....剩余资源量:1
Thread-0获得资源量，执行任务....剩余资源量:2
Thread-2释放资源量，给其他线程使用....剩余资源量:0
Thread-0释放资源量，给其他线程使用....剩余资源量:0
Thread-1释放资源量，给其他线程使用....剩余资源量:0
Thread-3获得资源量，执行任务....剩余资源量:0
Thread-4获得资源量，执行任务....剩余资源量:0
Thread-5获得资源量，执行任务....剩余资源量:0
Thread-3释放资源量，给其他线程使用....剩余资源量:0
Thread-4释放资源量，给其他线程使用....剩余资源量:1
Thread-6获得资源量，执行任务....剩余资源量:0
Thread-5释放资源量，给其他线程使用....剩余资源量:0
Thread-7获得资源量，执行任务....剩余资源量:0
Thread-8获得资源量，执行任务....剩余资源量:0
Thread-6释放资源量，给其他线程使用....剩余资源量:0
Thread-7释放资源量，给其他线程使用....剩余资源量:0
Thread-9获得资源量，执行任务....剩余资源量:0
Thread-8释放资源量，给其他线程使用....剩余资源量:1
Thread-9释放资源量，给其他线程使用....剩余资源量:2
```

## 2.互斥锁mutex
```java
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

```

```java
Thread-0获得锁.....,开始访问资源
Thread-0释放锁.....,其他线程可以访问资源
Thread-1获得锁.....,开始访问资源
Thread-1释放锁.....,其他线程可以访问资源
Thread-2获得锁.....,开始访问资源
Thread-2释放锁.....,其他线程可以访问资源
Thread-3获得锁.....,开始访问资源
Thread-3释放锁.....,其他线程可以访问资源
Thread-4获得锁.....,开始访问资源
Thread-4释放锁.....,其他线程可以访问资源
```