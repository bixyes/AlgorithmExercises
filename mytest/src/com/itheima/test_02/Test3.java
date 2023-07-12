package com.itheima.test_02;

import java.util.Arrays;

public class Test3 {
    /**
     * ### 案例一：两数之和
     *给定一个整数数组 nums和一个整数目标值 target，
     * 请你在该数组中找出 和为目标值 targe的那两个整数，并返回它们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
     * 你可以按任意顺序返回答案。
     */
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        System.out.println(Arrays.toString(towSum(nums, 13)));
    }
    public static int[] towSum(int[] nums,int target){
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j <nums.length ; j++) {
                if (target==nums[i]+nums[j]){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }
}
