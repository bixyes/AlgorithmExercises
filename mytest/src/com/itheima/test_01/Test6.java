package com.itheima.test_01;

import java.util.HashMap;
import java.util.Map;

public class Test6 {
    public static void main(String[] args) {
        countStr("aweihaoshuai1234ZHESHIDANGRANDE!!!");
    }

    public static void countStr(String s){
        char[] chars=s.toCharArray();
        //System.out.println(Arrays.toString(chars));
        HashMap<String,Integer> hashMap = new HashMap<>();
        for (char aChar : chars) {
            int m=aChar;
            if ('a'<=m&&m<='z'){
                hashMap.put("小写字母", hashMap.getOrDefault("小写字母", 0) + 1);
            }else if ('A'<=m&&m<='Z'){
                hashMap.put("大写字母", hashMap.getOrDefault("大写字母", 0) + 1);
            }else if ('0'<=m&&m<='9'){
                hashMap.put("数字", hashMap.getOrDefault("数字", 0) + 1);
            }else {hashMap.put("其他字符", hashMap.getOrDefault("其他字符", 0) + 1);}
        }
        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            System.out.println(entry.getKey()+":"+entry.getValue()+"个");
        }
    }
}
