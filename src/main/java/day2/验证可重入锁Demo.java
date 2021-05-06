package day2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class 验证可重入锁Demo {
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new Thread(()->{
                test1();
            },"线程"+i).start();
        }

        for (int i = 44; i < 47; i++) {
            new Thread(()->{
                test2(1);
            },"线程"+i).start();
        }
    }

    static synchronized void test1(){
        System.out.println(Thread.currentThread().getName()+"进入了方法1");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        test2(55555);
        System.out.println(Thread.currentThread().getName()+"出去了方法1====");
    }

    static synchronized void test2(int a){
        System.out.println(Thread.currentThread().getName()+"进入了方法2===="+a);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"出去了方法2===="+a);
    }
}
