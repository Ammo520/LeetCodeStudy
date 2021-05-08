package day2;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.WeakHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class String的问题 {
    static Integer user;
    private static final String a = "hello";

    public static void main(String[] args) {
        String str = new StringBuilder("he").append("llo").toString();
        System.out.println(str.intern() == str);
        System.out.println(str == a);
        System.out.println(str.intern() == a);
    }

}
