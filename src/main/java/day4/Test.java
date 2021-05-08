package day4;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class Test {

    public synchronized void test1() {
        System.out.println(Thread.currentThread().getName() + "test1");
        try {
            Thread.sleep(2000);
            LockSupport.park();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Demo.test1();
    }

    public synchronized void test2() {
        System.out.println(Thread.currentThread().getName() + "test2");
    }

    public static void main(String[] args) {
        Test test = new Test();
        new Thread(() -> {
            test.test1();
        }, "t1").start();
        new Thread(() -> {
            Demo.test1();
        }, "t2").start();
    }
}

class Demo {
    public static synchronized void test1() {
        System.out.println(Thread.currentThread().getName() + "test2");
    }
}
