package search;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 二分查找
 */
public class BinarySearch {
    public static void main(String[] args) {
        int []arr = {1,2,3,4,5,5,6,7,8,9};
        int left = 0;
        int right = arr.length-1;
        System.out.println(binarySearch(arr, left, right,5));
    }

    private static ArrayList<Integer> binarySearch(int[] arr, int left, int right, int num) {

        int l = left;
        int r = right;
        int mid = (l + r) / 2;
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (l > r){
            return new ArrayList<>();
        }
        if (num < arr[mid]){
            return binarySearch(arr, l, mid-1, num);
        }else if(num > arr[mid]){
            return binarySearch(arr, mid+1, r, num);
        }else{
            //向左遍历查找如果要查找的数字存在重复的话返回所有重复索引
            int temp = mid-1;
            while (true){
                if(temp < 0 || arr[temp] != num){
                    break;
                }
                arrayList.add(temp);
                temp -= 1;
            }
            arrayList.add(mid);

            temp = mid+1;
            while (true){
                if(temp > arr.length-1 || arr[temp] != num){
                    break;
                }
                arrayList.add(temp);
                temp += 1;
            }
            return arrayList;
        }
    }
}
