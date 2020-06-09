package sort;

import java.util.Arrays;

/**
 * 希尔排序
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        //基本思路，第一组
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
        //基本思路，第二组
        for (int i = 2; i < arr.length; i++) {
            for (int j = i-2; j >=0 ; j-=2) {
                if(arr[j] > arr[j+2]){
                    int temp = arr[j];
                    arr[j] = arr[j+2];
                    arr[j+2] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));

        //基本思路，第三组
        for (int i = 1; i < arr.length; i++) {
            for (int j = i-1; j >=0 ; j-=1) {
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }*/


        //希尔排序交换法实现
        /*for (int gap = arr.length/2; gap >0 ; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i-gap; j >= 0 ; j-=gap) {
                    if(arr[j] > arr[j+gap]){
                        int temp = arr[j];
                        arr[j] = arr[j+gap];
                        arr[j+gap] = temp;
                    }
                }
            }
        }*/

        //希尔排序移位法实现
        for (int gap = arr.length/2; gap >0; gap/=2) {
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                if(temp < arr[j-gap]){
                    while(j-gap >= 0 && temp < arr[j-gap]){
                        arr[j] = arr[j-gap];
                        j -= gap;
                    }
                    arr[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));

        /*for (int gap = arr.length/2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                while(j >= 0 && temp < arr[j - gap]){
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                arr[j] = temp;
            }
        }*/
    }
}
