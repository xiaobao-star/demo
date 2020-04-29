package thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 循环屏障类控制线程顺序保证线程顺序执行
 */
public class DemoCyclicBarrier {
    public static void main(String[] args){
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,() -> {System.out.println("召唤神龙!");});
        for (int i = 0; i < 7; i++) {
            final  int  tem = i;
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName()+"收集到"+tem+"课龙珠");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }
    }
}
