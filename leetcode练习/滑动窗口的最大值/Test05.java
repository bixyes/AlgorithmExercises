package com.itheima.test01;

import java.util.Arrays;

public class Test05 {
    //给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
    //示例:
    //输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
    //输出: [3,3,5,5,6,7]
    //解释:
    //
    //  滑动窗口的位置                最大值
    //---------------               -----
    //[1  3  -1] -3  5  3  6  7       3
    // 1 [3  -1  -3] 5  3  6  7       3
    // 1  3 [-1  -3  5] 3  6  7       5
    // 1  3  -1 [-3  5  3] 6  7       5
    // 1  3  -1  -3 [5  3  6] 7       6
    // 1  3  -1  -3  5 [3  6  7]      7
    //
    public static void main(String[] args) {
      int  nums[] = {1,3,-1,-3,5,3,6,7};
      System.out.println(Arrays.toString(maxSlidingWindow(nums, 3)));

    }
    public static  int[] maxSlidingWindow(int[] nums, int k) {
        int temp[] = new int[nums.length-k+1];
        int n=0;
        for (int i = 0; i+k < nums.length+1; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j <i+k; j++) {
                if(max<nums[j]){
                    max = nums[j];
                }
            }
            temp[n++] = max;
        }
        return temp;
    }
}
