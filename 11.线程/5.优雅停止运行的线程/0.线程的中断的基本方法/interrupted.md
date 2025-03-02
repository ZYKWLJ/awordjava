# interrupted() ——Thread 类静态方法，用于检查当前线程的中断状态。

# 一、作用

## 1.检查
检查当前线程的中断状态，如果线程被中断则返回 true，否则返回 false。

## 2.副作用
该方法具有副作用，即调用后**会清除当前线程的中断状态**（将**中断状态重置为 false**）。


# 二、适用场景

适用于**需要检查并清除**当前线程中断状态的场景。例如，在处理完一次中断后，希望后续逻辑**不受该中断状态的影响**，
就可以使用 interrupted() 方法。


# 三、示例代码
```java
public class testInterrupted {
    public static void main(String[] args) {
        // 最初终端位为false！
        System.out.println("当前中断状态: "+Thread.interrupted());
        System.out.println("调用interrupt方法将当前线程中断位设置为true");
        // 设置为中断位为true！
        Thread.currentThread().interrupt();
        // 第一次调用，返回 true 并清除中断状态
        System.out.println("当前中断状态: "+Thread.interrupted());
        System.out.println("因为检查方法interrupted()具有清除中断位的副作用，即又设置回了false，再次检测中断位");
        // 第二次调用，返回 false
        System.out.println("当前中断状态: "+Thread.interrupted());
    }
}

```