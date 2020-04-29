package thread;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch:倒计时门闩
 * 保证线程顺序执行
 */
public class DemoCountDownLatch {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 0; i < 6 ; i++) {
            new Thread(() -> {
                System.out.println("离开教室");
                countDownLatch.countDown();
            },"A").start();
        }
        countDownLatch.await();
        System.out.println("班长走人");
    }
}
