package sort;

import java.util.Arrays;

/**
 * 选择排序
 * 将第一个元素假设为最小值，与后面的n-1个元素进行比较，第一轮比较之后将两个元素的位置呼唤
 * 第二轮从第二个元素与其后面的元素进行比较，找出最小值并与第二个元素交换位置，以此类推
 */
public class SelectSort {
    public static void main(String[] args) {
        int [] arr = {6, 2, 1, -1, -2, -5, 0};

        for (int i = 0; i < arr.length-1; i++) {
            int min = arr[i];
            int minindex = i;
            for (int j = i+1; j < arr.length; j++) {
                if(min > arr[j]){
                    min = arr[j];
                    minindex = j;
                }
            }
            arr[minindex] = arr[i];
            arr[i] = min;
        }
        System.out.println(Arrays.toString(arr));

        /*for (int i = 0; i < arr.length; i++) {
            if(arr[i] < arr[0]){
                int temp = arr[0];
                arr[0] = arr[i];
                arr[i] = temp;
            }
        }

        for (int i = 1; i < arr.length; i++) {
            if(arr[i] < arr[1]){
                int temp = arr[1];
                arr[1] = arr[i];
                arr[i] = temp;
            }
        }

        for (int i = 2; i < arr.length; i++) {
            if(arr[i] < arr[2]){
                int temp = arr[2];
                arr[2] = arr[i];
                arr[i] = temp;
            }
        }

        for (int i = 3; i < arr.length; i++) {
            if(arr[i] < arr[3]){
                int temp = arr[3];
                arr[3] = arr[i];
                arr[i] = temp;
            }
        }

        for (int i = 4; i < arr.length; i++) {
            if(arr[i] < arr[4]){
                int temp = arr[4];
                arr[4] = arr[i];
                arr[i] = temp;
            }
        }

        for (int i = 5; i < arr.length; i++) {
            if(arr[i] < arr[5]){
                int temp = arr[5];
                arr[5] = arr[i];
                arr[i] = temp;
            }
        }*/



        System.out.println("数组为:"+ Arrays.toString(arr));
    }
}
