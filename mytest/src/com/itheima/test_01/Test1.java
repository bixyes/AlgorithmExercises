package com.itheima.test_01;

import java.util.ArrayList;

public class Test1 {
    public static void main(String[] args) {

        ArrayList<Integer> count=new ArrayList<>();
        for (int i = 0; i <1000 ; i++) {
            if (isCountSum(i)){
                count.add(i);
            }
        }

        System.out.println("水仙花的个数为："+count.toString());
    }

    public static boolean isCountSum(int num){
        String s=num+"";
        if (s.length()!=3){
            //System.out.println("水仙花的个数错误！");
            return false;
        }
        int g=s.charAt(0)-'0';
        int shi=s.charAt(1)-'0';
        int bai=s.charAt(2)-'0';

        int sum=g*g*g+shi*shi*shi+bai*bai*bai;
        if (num!=sum){
            //System.out.println("水仙花个数错误！");
            return false;
        }
        return  true;
    }
}
