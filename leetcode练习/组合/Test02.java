package com.fangwaylee.test01;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 *
 * 你可以按 任何顺序 返回答案。
 * 输入：n = 4, k = 2
 * 输出：
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 */

public class Test02 {
    public static void main(String[] args) {
        List<List<Integer>> combine = combine(4, 2);
        System.out.println(combine);
    }
    public static List<List<Integer>> combine(int n, int k) {
        // 创建一个空的结果列表
        List<List<Integer>> result = new ArrayList<>();
        // 调用辅助函数 backtrack
        backtrack(1, n, k, new ArrayList<>(), result);
        // 返回结果列表
        return result;
    }

    public static void backtrack(int start, int n, int k, List<Integer> path, List<List<Integer>> result) {
        // 如果 path 的长度等于 k
        if (path.size() == k) {
            // 将 path 的拷贝加入结果列表中
            result.add(new ArrayList<>(path));
            // 返回
            return;
        }
        // 从 start 到 n 遍历每个数字 i
        for (int i = start; i <= n; i++) {
            // 将 i 加入 path 中
            path.add(i);
            // 递归调用 backtrack(i + 1, n, k, path, result)
            backtrack(i + 1, n, k, path, result);
            // 将 i 从 path 中移除
            path.remove(path.size() - 1);
        }
    }
}
