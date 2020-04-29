package thread;

import com.sun.jmx.snmp.tasks.ThreadService;

import java.util.Arrays;
import java.util.concurrent.*;

/**
 * 自定义线程池
 */
public class DemoThreadPool {
    public static void main(String[] args){
        ExecutorService threadService = new ThreadPoolExecutor(2,
                5,
                2L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
        for (int i = 0; i < 9; i++) {
            threadService.execute(()->{
                System.out.println(Thread.currentThread().getName()+"办理业务");
            });
        }
    }
}
