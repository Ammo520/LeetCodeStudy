package day2;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Test {
    static Integer user;

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(() -> {
                login(finalI);
            }, "线程" + i).start();
        }
        System.out.println("最后登录用户："+Test.user);

    }

    static void login(Integer user) {
        System.out.println("当前登录用户：" + user);
        Test.user = user;
    }
}
