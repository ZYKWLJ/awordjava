import java.util.HashMap;
import java.util.concurrent.CountDownLatch;

class Node<E> {
    Node<E> ptrL, ptrR;
    E e;

    public Node(E e) {
        this.ptrL = null;
        this.ptrR = null;
        this.e = e;
    }

    public Node() {
    }
}

public class LRU<E> {
    // 显然使用哈希完成计数+双向链表完成去除工作
    // 每一次删除L,每一次增加在R,LR为两个虚拟边界
    Node<E> L, R;
    HashMap<E, Node<E>> valAndNodeMap;// 记录值和节点的映射(因为我们是访问的值嘛~)
    int capacity;// 新增缓存容量限制
    int currentCapacity;

    // 初始化
    public LRU(int capacity) {
        // 初始化 L 和 R（记得要初始化哦~）
        L = new Node<E>(null);
        R = new Node<E>(null);
        // 初始化 count
        valAndNodeMap = new HashMap<>();
        // 构建双向链表
        L.ptrL = null;
        L.ptrR = R;
        R.ptrL = L;
        R.ptrR = null;
        this.capacity = capacity;// 新增缓存容量限制
        this.currentCapacity = 0;
    }

    // 添加元素
    public E addE(E e) {
        if (isOverCapacity()) {
            System.out.println("Over Capacity, del the least use elem "+L.ptrR.e);
            // 超容删除
            delEWhileOverCapacity();
        }
        this.currentCapacity++;
        Node<E> newNode = new Node<>(e);
        // 判断是不是在链表中，在的话，先断开之前的元素
        if (valAndNodeMap.containsKey(e)) {
            System.out.println("elem " + e + " had existed! break first!");
            Node<E> node = valAndNodeMap.get(e);
            node.ptrR.ptrL = node.ptrL;
            node.ptrL.ptrR = node.ptrR;
        }
        // 在双向链表R边加上
        Node<E> RL = R.ptrL;
        RL.ptrR = newNode;
        newNode.ptrL = RL;
        newNode.ptrR = R;
        R.ptrL = newNode;
        valAndNodeMap.put(e, newNode);// 加入哈希表！
        System.out.println("elem " + e + " add success!");
        return e;
    }

    // 删除元素
    public void delE(E e) {
        if (!valAndNodeMap.containsKey(e)) {
            System.out.println("the aim elem " + e + " is not set in the table");
            return;
        }
        Node<E> node = valAndNodeMap.get(e);
        node.ptrR.ptrL = node.ptrL;
        node.ptrL.ptrR = node.ptrR;
        this.currentCapacity--;
        valAndNodeMap.remove(e);
        System.out.println("del elem " + e + " success!");
    }

    // 打印元素
    public void printE() {
        System.out.println("print the LRU:");
        Node<E> node = L.ptrR;
        while (node != R) {
            System.out.print(node.e + " ");
            node = node.ptrR;
        }
        System.out.println();
    }

    // 判断是否超容
    private boolean isOverCapacity() {
        return this.capacity <= this.currentCapacity;
    }

    // 超容删除
    private void delEWhileOverCapacity(){
        valAndNodeMap.remove(L.ptrR.e);
        L.ptrR=L.ptrR.ptrR;
        L.ptrR.ptrL=L.ptrL;
        
    }

    public static void main(String[] args) {
        LRU<String> lru = new LRU<String>(20);
        for (int i = 0; i < 20; i++) {
            lru.addE(i + "");
        }
        lru.printE();

        for (int i = 20; i < 40; i++) {
            lru.addE(i + "");
        }
        lru.printE();

        for (int i = 2; i < 20; i++) {
            lru.addE(i + "");
        }
        
        lru.printE();
    }
}