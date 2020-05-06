package lock;

/**
 * 自旋锁，是指尝试获取锁的线程不会立即阻塞，而是采用循环的方式去尝试获取锁，这样的好处是减少线程
 * 上下文切换的消耗，缺点是循环会消耗cpu
 */
public class SpinlockDemo {
}
