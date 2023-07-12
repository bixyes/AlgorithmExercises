package com.itheima.test_01;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

public class Test7 {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(randomNum(10, 10, 1)));
    }

    public static int[] randomNum(int n,int max,int min){
        if (max<=min){
            System.out.println("范围输入错误！");
            return null;
        }
        Random r = new Random();
        int[] randomNums = new int[n];
        HashSet<Integer> hashSet = new HashSet();
        while (hashSet.size()<10){
            hashSet.add(r.nextInt(max-min+1)+min);
        }
        int i=0;
        for (Integer integer : hashSet) {
            randomNums[i]=integer;
            i++;
        }
        return randomNums;
    }
}
