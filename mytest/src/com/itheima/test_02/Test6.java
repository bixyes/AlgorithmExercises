package com.itheima.test_02;

public class Test6 {
    /**
     * 案例六：最长回文子串
     * 需求：
     * 	给你一个字符串 `s`，找到 `s` 中最长的回文子串。
     * 	如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
     * 	123102211
     * 	1
     */
    public static void main(String[] args) {
        String s = "babad";
        String longestPalindrome = longestPalindrome(s);
        System.out.println(longestPalindrome);
    }

    public static String longestPalindrome(String s){
        if (s==null || s.length()<1){
            return null;
        }
        int start=0;
        int end=0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s,i,i);//以索引为i的字符为中心向两边拓展
            int len2 = expandAroundCenter(s,i,i+1);////以索引为i和i+1的字符为中心向两边拓展
            int len = Math.max(len1,len2);
            if (len>end-start){
                start = i-(len-1)/2;
                end = i+len/2;
            }
        }
        return s.substring(start,end+1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        while (left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        return right-left-1;
    }


}
