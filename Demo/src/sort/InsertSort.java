package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.logging.SimpleFormatter;

/**
 * 插入排序
 * 将第一个元素当作有序列表，后面的元素当作无序列表，从无序列表中拿出一个数字与有序列表中的数字做比较，根据大小进行插入
 */
public class InsertSort {
    public static void main(String[] args) {
        Date date = new Date();
        SimpleDateFormat simpleFormatter = new SimpleDateFormat("yyyy-MM-dd:HH:mm:ss");
        System.out.println("开始的时间为:" + simpleFormatter.format(date));

        int[] arr = new int[5];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 80000);
        }
        sortInsert(arr);

        Date date1 = new Date();
        SimpleDateFormat simpleFormatter1 = new SimpleDateFormat("yyyy-MM-dd:HH:mm:ss");
        System.out.println("结束的时间为:" + simpleFormatter1.format(date1));
    }

    private static void sortInsert(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int insertVal = arr[i];
            int insertIndex = i - 1;
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            arr[insertIndex + 1] = insertVal;
        }
    }
}
