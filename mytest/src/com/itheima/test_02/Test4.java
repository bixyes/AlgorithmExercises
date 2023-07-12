package com.itheima.test_02;

public class Test4 {
    /**
     * 给你一个**非空**整数数组nums，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素
     * 比如：
     * 	输入：nums = [2,2,1]	输出：1
     * 输入：nums = [4,1,2,1,2]	输出：4
     * 输入：nums = [1]		输出：1
     */
    public static void main(String[] args) {
        int[] nums={1,2,2,3,4,4,1};
        System.out.println(onceNum(nums));
    }
    public static int onceNum(int[] nums){
        int result=0;
        for (int num : nums) {
            result^=num;
        }
        return result;
    }
}
