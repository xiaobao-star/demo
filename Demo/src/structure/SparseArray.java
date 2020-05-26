package structure;

import java.io.*;

/**
 * 二维数组转稀疏数组思路
 * 1.遍历原始数组，得到有效数据的个数sum
 * 2.根据sum创建稀疏数组sparsearray[sum+1][3]
 * 3.将二维数组的有效数据存入稀疏数组
 */
public class SparseArray {
    public static void main(String[] args) {
        //原始二维数组
        int arr[][]  = new int[11][11];
        arr[1][2] = 1;
        arr[2][3] = 2;
        for (int [] ar : arr){
            for(int a : ar){
                System.out.printf("%d\t",a);
            }
            System.out.printf("\n");
        }

        //拿到二维数组的有效个数
        int num = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if(arr[i][j] != 0){
                    num++;
                }
            }
        }
        System.out.println("num"+num);

        //转稀疏数组
        int sparseArrays[][] = new int[num+1][3];
        sparseArrays[0][0] = 11;
        sparseArrays[0][1] = 11;
        sparseArrays[0][2] = num;
        //遍历稀疏数组
        int count = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if(arr[i][j] != 0){
                    count ++;
                    sparseArrays[count][0] = i;
                    sparseArrays[count][1] = j;
                    sparseArrays[count][2] = arr[i][j];
                }
            }
        }
        //稀疏数组
        for (int [] ar : sparseArrays){
            for(int a : ar){
                System.out.printf("%d\t",a);
            }
            System.out.printf("\n");
        }

        //将稀疏数组转化为二维数组
        int arrr[][] = new int[sparseArrays[0][0]][sparseArrays[0][1]];
        for (int i = 0; i < sparseArrays[0][2]+1; i++) {
            for (int j = 0; j < 3; j++) {
                if(i != 0){
                    arrr[sparseArrays[i][0]][sparseArrays[i][1]] = sparseArrays[i][2];
                }
            }
        }
        System.out.printf("\n");
        //稀疏数组
        for (int [] arr1 : arrr){
            for(int a : arr1){
                System.out.printf("%d\t",a);
            }
            System.out.printf("\n");
        }
    }
}

















