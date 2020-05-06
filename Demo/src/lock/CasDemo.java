package lock;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *为了保证原子性
 *
 * 底层调用了java 的unsafe类中的native类型的方法和CAS思想去进行当前主物理内存的值与快照区副本值得比较，如果相同修改如果不同重新读取主物理内存得值回快照区，
 * 这个时候由于value被volatile修饰所以其他线程得修改操作都能被当前线程获知，直到成功写入操作成功
 *
 *
 * 为什么atomicInteger要用unseaf而不用synconized？
 * 因为sync锁虽然保证了数据得一致性但是无法保证并发性
 * 而unseaf由于直接调用cpu得原子命令，原子命令是不可中断得，既保证了一致性也保证了并发性
 *
 *
 * CAS缺点
 * 1.如果比较不成功，会一直进行尝试，如果长时间不成功，会加大cpu得开销
 * 2.只能进行一个共享变量得原子操作，对于多个共享变量操作时，CAS就无法保证操作得原子性  这个时候就需要加锁
 */
public class CasDemo {
    public static void main(String[] args){
        //主物理内存中得值
        AtomicInteger atomicInteger = new AtomicInteger(5);

        //将主物理内存中的值与线程私有内存区的快照值进行比较，看是否被其他线程修改，如果相同才进行修改
        atomicInteger.compareAndSet(5,10);
        atomicInteger.compareAndSet(10,20);


        System.out.println(atomicInteger.get());
    }
}
