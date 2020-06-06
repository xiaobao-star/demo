package sort;

import java.util.Arrays;

/**
 * 希尔排序
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};

        /*for (int i = 5; i < arr.length; i++) {
            for (int j = i-5; j >=0 ; j-=5) {
                if(arr[j] > arr[j+5]){
                    int temp = arr[j];
                    arr[j] = arr[j+5];
                    arr[j+5] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));

        for (int i = 2; i < arr.length; i++) {
            for (int j = i-2; j >=0 ; j-=2) {
                if(arr[j] > arr[j+2]){
                    int temp = arr[j];
                    arr[j] = arr[j+2];
                    arr[j+2] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));*/

        for (int gap = arr.length/2; gap >0 ; gap /= 2) {
            for (int i = 1; i < arr.length; i++) {
                for (int j = i-1; j >= 0 ; j-=1) {
                    if(arr[j] > arr[j+1]){
                        int temp = arr[j];
                        arr[j] = arr[j+1];
                        arr[j+1] = temp;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
