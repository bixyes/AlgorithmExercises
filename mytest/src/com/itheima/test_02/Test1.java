package com.itheima.test_02;

import java.util.ArrayList;
import java.util.List;

public class Test1 {//求质数
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <10 ; i++) {
            if (isZS(i)){
                list.add(i);
            }
        }
        System.out.println(list);
    }

    public static boolean isZS(int num){
        if (num<=0){
            return false;
        }
        for (int i = 2; i <=Math.sqrt(num) ; i++) {
            if (num%i==0){
                return false;
            }
        }
        return true;
    }
}
