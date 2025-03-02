# isInterrupted() 是 Thread 类的实例方法，用于检查调用该方法的线程对象的中断状态。

# 一、作用：
**检查指定线程对象的中断状态**，如果线程被中断则返回 true，否则返回 false。
该方法**不会改变线程的中断状态**，即多次调用该方法，如果线程的中断状态没有被其他操作改变，返回的结果是一致的。

# 二、适用场景

适用于**仅需要检查线程中断状态而不希望改变它的场景**。例如，在某些情况下，需要根据线程的中断状态做出不同的处理，但后续逻辑还可能依赖该中断状态，此时就可以使用 isInterrupted() 方法。


# 三、示例代码
```java

public class testisInterrupted {
    public static void main(String[] args) {
        System.out.println("当前线程中断状态: " + Thread.currentThread().isInterrupted());
        System.out.println("调用interrupt方法将当前线程中断位设置为true");
        // 设置为中断位为true！
        Thread.currentThread().interrupt();
        // 第一次调用，返回 true 并清除中断状态
        System.out.println("当前中断状态: " + Thread.currentThread().isInterrupted());
        System.out.println("因为检查方法isInterrupted()没有任何副作用，再次检测中断位依然是一样的");
        // 第二次调用，返回 false
        System.out.println("当前中断状态: " + Thread.currentThread().isInterrupted());

    }
}

```