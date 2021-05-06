package day2;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class 自旋锁 {
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                MyLock.lock();
                System.out.println(Thread.currentThread().getName() + "=======================");
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                MyLock.unLock();
            }, "线程" + i).start();
        }
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
    }

}

class MyLock {
    private static final AtomicReference<Thread> ATOMIC_REFERENCE = new AtomicReference<>();

    static void lock() {
        Thread thread = Thread.currentThread();
        do {
            System.out.println(thread.getName() + "正在获取锁");
        } while (!ATOMIC_REFERENCE.compareAndSet(null, thread));
        System.out.println(thread.getName() + "获取成功了=======================");
    }

    static void unLock() {
        ATOMIC_REFERENCE.compareAndSet(Thread.currentThread(), null);
    }
}