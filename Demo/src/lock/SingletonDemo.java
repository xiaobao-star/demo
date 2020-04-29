package lock;

/**
 * 单例模式demo
 *
 * 在高并发多线程的情况下为了保证单例模式的安全性需要增加双端检索机制(dcl double check lock) 但是还有可能因为编译器的指令重排导致
 * 在判断实例不为空的时候对象还没有初始化而产生的构造方法多次被执行即产生多个对象，所以还需要添加volatile关键字禁止指令重排
 */
public class SingletonDemo {

    private static volatile SingletonDemo instance = null;

    private SingletonDemo(){

    }

    public static SingletonDemo getInstance()
    {
        if(instance == null)
        {
            //双端检索机制保证多线程模式下单例模式的安全性
            synchronized (SingletonDemo.class){
                if(instance == null)
                {
                    instance = new SingletonDemo();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args){
      System.out.println(SingletonDemo.getInstance() == SingletonDemo.getInstance());
      System.out.println(SingletonDemo.getInstance() == SingletonDemo.getInstance());
      System.out.println(SingletonDemo.getInstance() == SingletonDemo.getInstance());
    }
}
