package sort;

import java.util.Arrays;

/**
 * 归并排序
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        int []temp = new int [arr.length];
        margetSort(arr, 0, arr.length-1, temp);
        System.out.println(Arrays.toString(arr));
    }

    public static void margetSort(int []arr, int left, int right, int []temp){
        if(left < right){
            int mid = (left + right) / 2;
            //向左递归进行分解
            margetSort(arr, left, mid, temp);
            //向右递归进行分解
            margetSort(arr, mid+1, right, temp);
            //合并
            marget(arr, left, mid, right, temp);
        }
    }

    //合并
    private static void marget(int []arr, int left, int mid, int right, int []temp){
        int i = left;
        int j = mid+1;
        int t = 0;

        while (i <= mid && j <= right){
            if(arr[i] <= arr[j]){
                temp[t] = arr[i];
                t++;
                i++;
            }else{
                temp[t] = arr[j];
                j++;
                t++;
            }
        }

        while (i <= mid){
            temp[t] = arr[i];
            t++;
            i++;
        }

        while (j <= right){
            temp[t] = arr[j];
            t++;
            j++;
        }

        //将temp数组的元素拷贝到arr，不是每一次都拷贝所有
        t = 0;
        int tempLeft = left;
        while (tempLeft <= right){
            arr[tempLeft] = temp[t];
            t += 1;
            tempLeft += 1;
        }
    }
}
