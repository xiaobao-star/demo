package sort;

import java.util.Arrays;

/**
 * 插入排序
 * 将第一个元素当作有序列表，后面的元素当作无序列表，从无序列表中拿出一个数字与有序列表中的数字做比较，根据大小进行插入
 */
public class InsertSort {
    public static void main(String[] args) {
        int [] arr = {6, 2, 1, -1};

        int insertVal = arr[1];
        int insertIndex = 1 - 1;
        while(insertIndex >= 0 && insertVal < arr[insertIndex]){
            arr[insertIndex+1] = arr[insertIndex];
            insertIndex --;
        }
        arr[insertIndex+1] = insertVal;

        System.out.println(Arrays.toString(arr));
    }
}
