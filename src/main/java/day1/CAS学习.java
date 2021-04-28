package day1;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

public class CAS学习 {

    public static void main(String[] args) {

    }

    private static void demo1() {
        AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(123,1);
        atomicStampedReference.compareAndSet(123,234,1,2);
        AtomicReference<Integer> atomicReference = new AtomicReference<>(123);
        atomicReference.compareAndSet(123,234);
    }
}
