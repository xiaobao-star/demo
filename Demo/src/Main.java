import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.System.out;
import static java.lang.System.setOut;

class  Foo{
    private Lock lock = new ReentrantLock();
    private int number = 0;

    public synchronized void add(){
        while(number != 0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

            number++;
            out.println(Thread.currentThread().getName()+number);
            this.notifyAll();

    }

    public synchronized void del() {
        while(number == 0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
            number--;
            out.println(Thread.currentThread().getName()+number);
            this.notifyAll();
    }

}
public class Main {
    public static void main(String[] args) {
        Foo foo = new Foo();

        new Thread(() -> {
            for (int i = 0;i<10;i++){
                foo.add();
            }
        },"A").start();
        new Thread(() -> {
            for (int i = 0;i<10;i++){
                foo.del();
            }
        },"B").start();
    }
};


