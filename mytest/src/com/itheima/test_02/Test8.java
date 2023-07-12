package com.itheima.test_02;

public class Test8 {
    /**
     * ### 案例八：字符串中的第一个唯一字符（不做要求，有兴趣的同学自己可以看一下代码逻辑）
     * 给定一个字符串s，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回-1。
     * 比如：
     * 	输入: s = "leetcode"
     * 	输出: 0
     * 	输入: s = "loveleetcode"
     * 	输出: 2
     * 	输入: s = "aabb"
     * 	输出: -1
     */
    public static void main(String[] args) {
        System.out.println(index("120120"));
    }
    public static int index(String s){
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (s.indexOf(ch)==s.lastIndexOf(ch)){
                return s.indexOf(ch);
            }
        }
        return -1;
    }
}
