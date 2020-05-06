package thread;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

import static java.lang.System.out;

/**
 * 请举例说明arrayList是不安全的
 *
 * 解决方案
 * 1.new Vector();
 * 2.用Collections工具类转换成.synconizedList(new ArrayList<>());
 * 3.new CopyOnWriteArrayList<>();写时复制，读写分离得思想
 *
 * CopyOnWriteArrayList<>()是一种写时复制容器，往一个容器添加元素得时候
 * 不直接往当前容器Object[]添加，而是先复制出来一份新容器，往新容器中
 * 添加元素，添加完成以后再将原来容器得引用指向新容器setArray(newElements)
 * 这样做的好处是在并发环境得读时不需要加锁，CopyOnWrite是一种读写分离得思想
 * 读和写不同得容器
 * */
public class DemoArrayListNotSafe {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
       // new CopyOnWriteArrayList<>();写时复制
        for(int i = 0 ;i < 30 ;i++)
        {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list);
            }).start();
        }
    }
}
