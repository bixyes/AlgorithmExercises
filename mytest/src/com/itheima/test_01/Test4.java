package com.itheima.test_01;

import java.util.Random;

public class Test4 {
    public static void main(String[] args) {
        System.out.println(getCode(5));
    }

    public static String getCode(int length){
        String s="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String code="";
        Random r = new Random();
        for (int i = 0; i <length ; i++) {
            code+=s.charAt(r.nextInt(s.length()));
        }

        return code;
    }
}
