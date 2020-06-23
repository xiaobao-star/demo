package lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 自旋锁，是指尝试获取锁的线程不会立即阻塞，而是采用循环的方式去尝试获取锁，这样的好处是减少线程
 * 上下文切换的消耗，缺点是循环会消耗cpu
 */
public class SpinlockDemo {

    AtomicReference<Thread> atomicReference = new AtomicReference<>();


    public void myLock() {
        Thread thread = Thread.currentThread();
        while (!atomicReference.compareAndSet(null, thread)) {

        }
    }

    public void myUnLock() {
        Thread thread = Thread.currentThread();

        atomicReference.compareAndSet(thread, null);
    }

    public static void main(String[] args) {
        SpinlockDemo spinlockDemo = new SpinlockDemo();

        new Thread(() -> {
            spinlockDemo.myLock();
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            spinlockDemo.myUnLock();
        }, "AAA").start();

        new Thread(() -> {
            spinlockDemo.myLock();
            spinlockDemo.myUnLock();
        }, "BBB").start();
    }
}
