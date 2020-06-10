package sort;

import java.util.Arrays;

/**
 * 基数排序
 */
public class RadixSort {
    public static void main(String[] args) {

        int []arr = {1,3,43,45,6,7,4,52,3,23232,55454,5454,56,7,7,833,3,2,5};
        RadixSort1(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void RadixSort1(int[] arr) {
        int [][] bucket = new int[10][arr.length];
        int [] bucketElementCount = new int[10];
        //得到最大数
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] > max){
                max = arr[i];
            }
        }
        //max+"".length()得到最大数的位数
        for (int k = 0,n=1; k < (max+"").length(); k++,n *= 10) {
            //将数组中的元素根据个位数的数字放入对应的桶中
            for (int i = 0; i < arr.length; i++) {
                int genum = arr[i] /n %10; //分别拿到个位，十位，百位数字
                bucket[genum][bucketElementCount[genum]] = arr[i];
                bucketElementCount[genum]++;
            }

            //将桶中的元素放回数组中
            int index = 0;
            for (int i = 0; i < bucket.length; i++) {
                if(bucketElementCount[i] != 0){
                    for (int j = 0; j < bucketElementCount[i]; j++) {
                        arr[index++] = bucket[i][j];
                    }
                }
                //把桶中的元素清零
                bucketElementCount[i] = 0;
            }
        }
    }
}
