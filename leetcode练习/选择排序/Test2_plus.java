package com.itheima.d4_sf;

import java.util.Arrays;

public class Test2_plus {
    public static void main(String[] args) {
        // 目标：选择排序的优化，减少交换次数
        int[] arr = {5, 1, 3, 2};
        //           0  1  2  3

        // 1、定义循环控制选择几轮
        for (int i = 0; i < arr.length - 1; i++) {
            // 2、控制每轮选择几次。
            // i = 0  j = 1 2 3   比较次数 3
            // i = 1  j = 2 3     比较次数 2
            // i = 2  j = 3       比较次数 1
            int min = i;
            int minNum = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                // 3、判断遍历到的位置处的值（j），是否小于当前位置(i). 若较小则交换
               if (minNum>arr[j]){
                   minNum = arr[j];
                   min = j;
               }
            }
            arr[min] = arr[i];
            arr[i] = minNum;
        }
        System.out.println(Arrays.toString(arr));
    }
}
