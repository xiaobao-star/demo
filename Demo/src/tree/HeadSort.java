package tree;

import java.util.Arrays;

/**
 * 堆排序
 */
public class HeadSort {

    public static void main(String[] args) {
        int []arr = {5,9,4,8,6,10,22,33,44,-10};

        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    //进行建堆
    private static  void heapSort(int [] arr){
        int temp = 0;
        for (int i = arr.length/2 -1; i >=0 ; i--) {
            atJuadeHead(arr, i, arr.length);
        }

        for (int i = arr.length-1; i > 0 ; i--) {
            temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            atJuadeHead(arr, 0, i);
        }
    }
    
    private static void atJuadeHead(int []arr, int i, int length) {
        int temp = arr[i];

        for (int k = i * 2+1; k < length; k = k * 2+1) {
            if (k+1<length && arr[k] < arr[k+1]){
                k++;
            }
            if (arr[k] > temp){
                arr[i] = arr[k];
                i = k;
            }else{
                break;
            }
        }

        arr[i] = temp;
    }
}
