package sort;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        int left = 0;
        int right = arr.length-1;
        quickSort(arr,left,right);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        int pivot = arr[(left + right) / 2];
        int temp = 0;
        //while循环的目的是让比povot值小的数放左边，大的放右边
        while(l < r){
            //在pivot的左边一直找，找到比pivot数字大的才退出
            while (arr[l] < pivot) {
                l += 1;
            }
            //在pivot的右边一直找，找到比pivot数字小的才退出
            while (arr[r] > pivot){
                r -= 1;
            }
            //如果l >= r 说明pivot左右两边的值，已经全部按照左边是小于等于pivot，右边大于等于pivot
            if (l >= r ){
                break;
            }
            //交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            if (arr[l] == pivot){
                r -= 1;
            }

            if(arr[r] == pivot){
                l += 1;
            }
        }

        if(l == r){
            l += 1;
            r -= 1;
        }
        if(left < r){
            quickSort(arr, left, r);
        }
        if(right > l){
            quickSort(arr, l, right);
        }
    }
}
