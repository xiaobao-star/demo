import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.System.out;

/**
 *
 */
class Ziyuan{
    private int number = 0;
    private Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();


    public void add(){
        while(number != 0){
            try {
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        number++;
        System.out.println(Thread.currentThread().getName()+"---"+number);
        condition.signalAll();
        out.println();
    }

    public void del()
    {
        while(number == 0){
            try {
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        number--;
        out.println(Thread.currentThread().getName()+"---"+number);
        condition.signalAll();
    }
}

public class Demo1 {
    public static void main(String[] args) {
        Ziyuan ziyuan = new Ziyuan();

        new Thread(()-> {
            for (int i = 0;i<10;i++){
                ziyuan.add();
            }
        },"A");

        new Thread(()-> {
            for (int i = 0;i<10;i++){
                ziyuan.del();
            }
        },"C");
    }
}
