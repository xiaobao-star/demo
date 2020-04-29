package lock;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * volatile 轻量级的java同步锁机制
 * 1.保证可见性
 * 2.不保证原子性 所以引入了CAS compareandset方式
 * 3.禁止指令重排保证有序性
 *
 * 以下demo说明volatile可以保证线程之间通信的可见性
 */

public class VolatileTest {
    volatile int number = 0;

    public void addnumber()
    {
        this.number = 60;
    }

    public static void main(String[] args){
        VolatileTest volatileTest = new VolatileTest();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
                volatileTest.addnumber();
                System.out.println(Thread.currentThread().getName()+"number:"+volatileTest.number);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"A").start();

        while(volatileTest.number == 0)
        {

        }
        System.out.println("main线程出来了");
    }
}
