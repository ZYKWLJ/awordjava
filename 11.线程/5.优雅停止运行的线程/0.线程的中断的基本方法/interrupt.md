# 1. interrupt()——对象方法，中断阻塞线程OR设置非阻塞线程的中断位为true(相当于内置标志位)
public void interrupt()
## 一、定义
interrupt() 是 Thread 类的一个实例方法，用于**中断调用该方法的线程对象**。

## 二、作用
当线程处于阻塞状态（如**调用 sleep()、wait()、join() 等方法**）时，调用 interrupt() 会使该线程抛出 InterruptedException 异常，并且**会清除中断状态**。

当线程处于非阻塞状态时，调用 interrupt() **只是将该线程的中断状态标记为 true**，线程可以通过检查中断状态来决定是否进行相应的处理。

## 三、总结：

### 阻塞时：抛出异常+清除中断状态

### 非阻塞时：标记中断状态为true！

---
## 四、使用场景

通常用于**通知线程停止正在执行的任务**。例如，在一个长时间运行的线程中，当满足某些条件时，主线程可以调用该线程的 **interrupt() 方法来请求其停止执行**。


## 五、代码实例

```java
public class testInterrupt {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                for (int i = 0; i < 20; i++) {
                    System.out.println(i);
                }
                Thread.sleep(1000);
            } catch (InterruptedException e) {//只有当线程处于阻塞，如调用sleep()、wait()、join() 等方法时，才会调用异常！不然只是置中断位为true！
                System.out.println("线程被中断：" + e.getMessage());
            }
        });
        thread.start();
        Thread.sleep(500);
        thread.interrupt();// 主线程中断附线程
    }
}
```