package lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写分离的思想，写操作独占锁，读操作共享资源
 */
public class ReadWriteLock {
    volatile Map<String ,Object> map = new HashMap<>();
    ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

    public void put(String key, Object value){

        reentrantReadWriteLock.writeLock().lock();
        try
        {
            System.out.println(Thread.currentThread().getName()+"正在写入");
            map.put(key,value);
            System.out.println(Thread.currentThread().getName()+"写入完成");
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            reentrantReadWriteLock.writeLock().unlock();
        }
    }

    public Object get(String key){
        reentrantReadWriteLock.readLock();
        System.out.println(Thread.currentThread().getName()+"读取完成");
        return map.get(key);
    }

    public static void main(String[] args) {
        ReadWriteLock readWriteLock = new ReadWriteLock();

        for (int i = 0; i < 6; i++) {
            int tem = i;
            new Thread(() -> {
                readWriteLock.put(tem+"",tem +"");
            },String.valueOf(i)).start();
        }

        for (int i = 0; i < 6; i++) {
            int finalI = i;
            new Thread(() -> {
                readWriteLock.get(finalI +"");
                Thread.currentThread().getName();
            },String.valueOf(i)).start();
        }
    }
}
