# 一、Phaser概述

Phaser，**翻译为阶段**，它适用于这样一种场景，**一个大任务可以分为多个阶段完成**，且**每个阶段的任务可以多个线程并发执行**，但是**必须上一个阶段的任务都完成了才可以执行下一个阶段的任务**。 这种场景虽然使用CyclicBarrier或者CountryDownLatch也可以实现，但是要复杂的多。首先，具体需要多少个阶段是可能会变的，其次，每个阶段的任务数也可能会变的。相比于CyclicBarrier和CountDownLatch，Phaser更加灵活更加方便。

核心总结：
### 1.一个大任务分解成小任务
一个大任务可以分为多个阶段完成

### 2.每个阶段的任务可以多个线程并发执行


### 3.必须上一个阶段的任务都完成了才可以执行下一个阶段的任务

# 二、使用实例

```java
import java.util.concurrent.Phaser;

public class testPhaser {
    public static final int PARTIES = 3;// 参与同步的线程数量
    public static final int PHASES = 4;// 阶段数

    public static void main(String[] args) {
        Phaser phaser = new Phaser(PARTIES) {// 分几个阶段··
            @Override
            protected boolean onAdvance(int phase, int registeredParties) {// 表示
                System.out.println("=======phase: " + phase + " finished=============");
                return super.onAdvance(phase, registeredParties);
                // onAdvance 方法会在每个阶段结束，且所有注册的线程都到达当前阶段的同步点时被自动调用。
            }
        };

        for (int i = 0; i < PARTIES; i++) {// 这么多个阶段，按理说是乱序，但是这里是有序的挨阶段等待~~
            new Thread(() -> {
                for (int j = 0; j < PHASES; j++) {// 每个阶段的线程
                    System.out.println(String.format("%s: phase: %d", Thread.currentThread().getName(), j));
                    phaser.arriveAndAwaitAdvance();
                    // 线程调用该方法表示已经完成当前阶段的任务，并等待其他线程也完成当前阶段的任务。
                    // 当所有线程都调用了该方法后，Phaser 会进入下一个阶段，并调用 onAdvance 方法。
                }
            }, "Thread " + i).start();
        }
    }
}
```