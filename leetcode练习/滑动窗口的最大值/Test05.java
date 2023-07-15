package com.itheima.test01;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

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

    public  static  int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length-k+1];

        //存储数组元素的下标
        LinkedList<Integer> queue = new LinkedList<>();

        //遍历数组中的元素，right表示滑动窗口的右边界
        for (int right = 0; right < nums.length; right++) {
            // 如果队列不为空且当前考察元素大于等于队尾元素，则将队尾元素移除。
            // 直到，队列为空或当前考察元素小于新的队尾元素
            while (!queue.isEmpty()&&nums[right]>=nums[queue.peekLast()]){
                queue.removeLast();
            }

            //存储元素下标
            queue.addLast(right);

            //计算窗口左边界
            int left = right - k +1;

            // 当队首元素的下标小于滑动窗口左侧边界left时
            // 表示队首元素已经不再滑动窗口内，因此将其从队首移除
            if (queue.peekFirst()<left){
                queue.removeFirst();
            }

            // 由于数组下标从0开始，因此当窗口右边界right+1大于等于窗口大小k时
            // 意味着窗口形成。此时，队首元素就是该窗口内的最大值
            if (right+1>=k){
                res[left] = nums[queue.peekFirst()];
            }
        }

        return res;
    }

}
