package thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.System.out;

/**
 * 实现A线程打印5次，接着B线程打印10次，接着C线程15次，来10轮
 */
class Shareresource{
    private int number = 1;
    private Lock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();


    public  void print5()
    {
        lock.lock();
        while(number != 1)
        {
            try {
                condition1.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for(int i = 0;i<5;i++)
        {
            out.println(Thread.currentThread().getName()+"-"+number);
        }

        number = 2;
        condition2.signal();
    }
    public  void print10()
    {
        lock.lock();
        while(number != 2)
        {
            try {
                condition2.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for(int i = 0;i<10;i++)
        {
            out.println(Thread.currentThread().getName()+"-"+number);
        }

        number = 3;
        condition3.signal();
    }
    public  void print15()
    {
        lock.lock();
        while(number != 3)
        {
            try {
                condition3.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for(int i = 0;i<15;i++)
        {
            out.println(Thread.currentThread().getName()+"-"+number);
        }

        number = 1;
        condition1.signal();
    }
}

public class Demo2 {
    public static void main(String[] args) {

        Shareresource shareresource = new Shareresource();
        new Thread(()-> {
            for (int i = 0;i<10;i++){
                shareresource.print5();
            }
        },"A").start();

        new Thread(()-> {
            for (int i = 0;i<10;i++){
                shareresource.print10();
            }
        },"B").start();

        new Thread(()-> {
            for (int i = 0;i<10;i++){
                shareresource.print15();
            }
        },"C").start();
    }
}
