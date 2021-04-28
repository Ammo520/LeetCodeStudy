package day1;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Liao wenbo
 * @className Test
 * @date 2021/4/14
 */
public class Test {
    public AtomicInteger inc = new AtomicInteger();

    public void increase() {
        inc.getAndIncrement();
    }

    public static void main(String[] args) {
        final Test test = new Test();
        for (int i = 0; i < 10; i++) {
            new Thread() {
                @Override
                public void run() {
                    for (int j = 0; j < 1000; j++) {
                        test.increase();
                    }
                }
            }.start();
        }

        while (Thread.activeCount() > 1) {
            Thread.yield();
        }
        System.out.println(test.inc);
        String s = "s";
    }
}