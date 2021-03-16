package juc;
import sun.rmi.runtime.NewThreadAction;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class LockSupportDemo {
    //synchronizedWait
    static Object object = new Object();
    //Lock lock
    static Lock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();

    public static void main(String[] args) {

        /**
         * synchronizedWait , notify的阻塞唤醒使用的不便之处
         *    1.wait，notify必须在synchronized代码块中使用
         *    2.wait必须放在notify前面否则无法唤醒
         */
        //synchronizedWaitNotifyDemo();

        /**
         * lockawaitsignal的阻塞唤醒使用的不便之处
         *    1.await,signal必须在lock.lock()  lock.unlock()代码块中使用
         *    2.await必须放在signal前面否则无法唤醒
         */
        //lockReantrantLockDemo();


        /**
         * LockSupport的阻塞唤醒相较于以上的锁优势
         * Locksupport底层为unsafe直接调用本地native方法，每一个线程都存在一个通行证permit，默认为0，当park()调用时消耗凭证-1.当unpark()
         * 调用时候permit+1，但是permit最多只有1，只有当permit为1时park（）方法才有效，当连续多次unpark和park时会阻塞
         *
         *     1.无需考虑unpark和park的调用顺序，唤醒可以在阻塞之前
         *     2.没有代码块的约束
         */
        lockSupportDemo();
    }

    private static void lockSupportDemo() {
        Thread a = new Thread(() ->
        {
            System.out.println(Thread.currentThread().getName()+":被阻塞");
            LockSupport.park();
            System.out.println(Thread.currentThread().getName()+":被唤醒");

        },"A");
        a.start();

        new Thread(() ->
        {
            System.out.println("通知A");
            LockSupport.unpark(a);
        },"B").start();
    }

    private static void lockReantrantLockDemo() {
        new Thread(() ->
        {
            lock.lock();
            try
            {
                System.out.println(Thread.currentThread().getName()+":comme in");
                condition.await();
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName()+"被唤醒!");
            }catch (Exception e)
            {
            }finally {
                lock.unlock();
            }
        },"A").start();

        new Thread(() ->
        {
            lock.lock();
            try
            {
                System.out.println(Thread.currentThread().getName()+"通知A线程");
                condition.signal();
            }catch (Exception e)
            {
            }finally {
                lock.unlock();
            }
        },"B").start();
    }

    private static void synchronizedWaitNotifyDemo() {

        new Thread(() ->
        {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (object)
            {
                System.out.println(Thread.currentThread().getName()+"come in");
                try {
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println(Thread.currentThread().getName()+"被唤醒!");
        },"A").start();

        new Thread(() ->
        {
            synchronized (object)
            {
                System.out.println(Thread.currentThread().getName()+"通知");
                object.notify();
            }
        },"B").start();
    }
}
