package thread;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

import static java.lang.System.out;

/**
 * 请举例说明arrayList是不安全的
 * 1.Collections.synchronizedList(new ArrayList<String>());//转为线程安全
 * 2.new CopyOnWriteArrayList<>();
 */
public class Demo3 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        new CopyOnWriteArrayList<>();
        for(int i = 0 ;i < 30 ;i++)
        {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list);
            }).start();
        }
    }
}
