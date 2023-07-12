package com.itheima.test_01;

import java.util.Arrays;
import java.util.Random;

public class Test3 {
    public static void main(String[] args) {
       int[] array = randomNums(5,15,27);
        System.out.println(Arrays.toString(array));
        randomSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static int[] randomNums(int n,int min,int max){
        if (min>=max){
            System.out.println("输入范围错误！");
            return null;
        }
        int[] randomNums=new int[n];
        Random r = new Random();
        for (int i = 0; i < randomNums.length; i++) {
            randomNums[i] = r.nextInt(max-min+1)+min;
        }

        return randomNums;
    }

    public static void randomSort(int[] array){
        int temp=0;
        Random r = new Random();
        for (int i = 0; i < array.length; i++) {
            int random=r.nextInt(array.length);
            temp=array[i];
            array[i] = array[random];
            array[random]=temp;
        }
    }
}
