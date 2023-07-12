package com.itheima.test_02;

import java.util.Arrays;

public class Test5 {
    /**
     * ### 案例三：寻找两个正序数组的中位数
     * 	给定两个正序数组arr1和arr2，请先合并数组，并找出合并之后数组的**中位数**。
     * 	1 2 3 4 5 6 7 8 9    中位数：5
     * 1 2 3 4 5 6     		中位数：（ 3 + 4 ） / 2
     */
    public static void main(String[] args) {
        int[] nums1={1,2,3,4,5};
        int[] nums2={2,4,5,7};
        int[] ints = mergeOrderArray(nums1, nums2);
        System.out.println(Arrays.toString(ints));
        System.out.println(getArrMidNum(ints));
    }
    public static int[] mergeOrderArray(int[] arr1,int[] arr2){
        int len = arr1.length+arr2.length;
        int[] mergeArr = new int[len];
        int r=0;
        int l=0;
        for (int i = 0; i < mergeArr.length; i++) {
            if (r>=arr1.length){
                for (int j = l; j <arr2.length ; j++) {
                    mergeArr[i]=arr2[j];
                    i++;
                }
                return mergeArr;
            }
            if (l>=arr2.length){
                for (int j = r; j <arr1.length ; j++) {
                    mergeArr[i]=arr2[j];
                    i++;
                }
                return mergeArr;
            }
            if (arr1[r]<=arr2[l]){
                mergeArr[i]=arr1[r];
                r++;
            }else {
                mergeArr[i]=arr2[l];
                l++;
            }
        }
        return mergeArr;
    }

    public static double getArrMidNum(int[] nums){
        if (nums.length%2==0){
            return (nums[nums.length/2-1]+nums[nums.length/2])/2.0;
        }else {
            return nums[nums.length/2];
        }
    }
}
