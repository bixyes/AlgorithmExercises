package com.itheima.test03;

import java.util.Arrays;

public class Test05 {
    //给你一个按照非递减顺序排列的整数数组 `nums`，和一个目标值 `target`。请你找出给定目标值在数组中的开始位置和结束位置。
    //如果数组中不存在目标值 `target`，返回 `[-1, -1]`。
    public static void main(String[] args) {
        int[] nums ={5,7,7,8,8,10};

        System.out.println(Arrays.toString(getTargetIndex(7, nums)));
    }

    public static int[] getTargetIndex(int target,int[] nums){
        int left = 0;
        int right = nums.length-1;
        int mid = (left+right)/2;
        int[] res = {-1,-1};
        while (left<right){
            mid = (left+right)/2;
            if (nums[mid]<target){
                left =mid+1;
            }
            if (nums[mid]>target){
                right = mid-1;
            }
            if (nums[mid]==target){
                if (mid<nums.length&&mid>=0){
                    if (mid<nums.length-1&&nums[mid+1]==target){
                        res[0]=mid;
                        res[1]=mid+1;
                        break;
                    }
                    if (mid>0&&nums[mid-1]==target){
                        res[0]=mid-1;
                        res[1]=mid;
                        break;
                    }
                }

            }
        }
        return res;
    }
}
