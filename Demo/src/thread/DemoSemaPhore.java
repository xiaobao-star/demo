package thread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 多线程的资源控制和并发互斥
 */
public class DemoSemaPhore {

    //模拟多个线程抢夺多个资源
    public static void main(String[] args){
        Semaphore semaphore = new Semaphore(3);


        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"抢到车位");
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println(Thread.currentThread().getName()+"离开车位");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                }
            },String.valueOf(i)).start();
        }
    }
}
