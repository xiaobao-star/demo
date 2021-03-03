package algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个目标数组和一个目标数值，找出和为目标值得两个整数！,并返回这两个整树得索引
 */
public class TwoNumCount {
    public static void main(String[] args)
    {
        int [] test = twosum1(new int []{2,7,11,15},18);

        for (int t:test)
        {
            System.out.println(t);
        }
    }
    /**
     * 暴力解法
     */
    public static int[] twosum(int [] arr , int target)
    {
        int [] arr1 = new int [2];

        for (int i = 0; i < arr.length; i++)
        {
            for (int j = i+1; j < arr.length; j++)
            {
                if (arr[i]+arr[j] == target)
                {
                    arr1[0] = i;
                    arr1[1] = j;
                }
            }
        }
        return arr1;
    }

    /**
     * 哈希解法
     */
    public static int[] twosum1(int [] arr , int target)
    {
        Map<Integer , Integer> map = new HashMap<>();


        for (int i = 0; i < arr.length; i++)
        {
            int parent = target - arr[i];
            if (map.containsKey(parent))
            {
                return new int []{map.get(parent),i};
            }
            map.put(arr[i],i);
        }
        return null;
    }
}
