package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 获取多线程的第三种方法
 */
public class DemoCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("我来了");
        return 1024;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask futureTask = new FutureTask(new DemoCallable());

        new Thread(futureTask).start();
        System.out.println(futureTask.get());
    }
}
