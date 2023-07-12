package com.itheima.test_02;

import java.util.Arrays;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("88111211109"));
    }

    public static char[] manacherString(String s){ //将字符串转化为长度为2*字符串长度+1的数组
        char[] chars = new char[s.length()*2+1];
        char[] chars1 = s.toCharArray();
        int index=0;
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (i&1)==0?'#': chars1[index++];
        }
        return chars;
    }

    public static String  longestPalindrome(String s){
        char[] chars = manacherString(s);
        int start=0;
        int end = 0;
        int maxStart = 0;
        int maxEnd = 0;
        int max=Integer.MIN_VALUE;
        for (int i = 0; i < chars.length; i++) {
            start = i;
            end = i;
            while (start>0&&end<chars.length-1&&chars[start-1]==chars[end+1]){
                start--;
                end++;
            }
            int len=end-i;
            if (len>max){
                max=len;
                maxStart = start;
                maxEnd = end;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = maxStart; i < maxEnd; i++) {
            if (chars[i] != '#') {
                sb.append(chars[i]);
            }
        }

        return sb.toString();
    }


}
