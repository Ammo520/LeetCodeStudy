package day1;

import lombok.Synchronized;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

public class Volatile学习 {

    public static void main(String[] args) {
        new Thread(()->{
            method1();
        }).start();
        new Thread(()->{
            method2();
        }).start();
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
    }

    @Synchronized
    static void method1() {
        for (int i = 0; i < 300; i++) {
            System.out.println(1);
        }

    }

    static void  method2() {
        for (int i = 0; i < 300; i++) {
            System.out.println(22);
        }
    }
}
