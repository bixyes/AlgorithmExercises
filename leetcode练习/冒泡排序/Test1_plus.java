package com.itheima.d4_sf;

import java.util.Arrays;

public class Test1_plus {
    public static void main(String[] args) {
        // 目标：冒泡排序的实现。优化冒泡排序，加入了  Flag，目的是将算法的最佳时间复杂度优化为 O(n)，
        // 即当原输入序列就是排序好的情况下，该算法的时间复杂度就是 O(n)。
        int[] arr = {5, 2, 3, 1};
        //           0  1  2  3

        boolean flag = true;
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-1-i; j++) {
                if (arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    flag = false;
                }
            }

            if (flag){
                break;
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}
