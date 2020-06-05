package sort;

import java.util.Arrays;
import java.util.Random;

/**
 * 冒泡排序(bubblesort)
 */
public class MaopaoSort {
    public static void main(String[] args) {
        int [] arr = {1, 2, 4, 3, 6, 7, 8};

        boolean flag = false;
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-1-i; j++) {
                if(arr[j] > arr[j+1]){
                    flag = true;
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            System.out.println("第"+(i+1)+"躺后的数组:"+Arrays.toString(arr));

            if(!flag){
                break;
            }else{
                flag = false;
            }
        }
    }
}
