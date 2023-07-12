package com.itheima.test_02;

import java.util.Scanner;

public class Test2 {//传递一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num=sc.nextInt();
        is2Mi(num);
    }

    public static void is2Mi(int n){
        int num=log2(n);
        if (num==-1){
            System.out.println(false);
        }else {
            System.out.println(true);
            System.out.println("2的"+num+"次方="+n);
        }

        if (isPowerOfTwo(n)){
            int result = (int)(Math.log(n)/Math.log(2));
            System.out.println(result);
        }

    }
    public static boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        return (n & (n - 1)) == 0;//这个方法使用了位运算符 & 来检查 n 是否是 2 的幂次方。如果 n 是 2 的幂次方，
        // 那么它的二进制表示中只有一位是 1，而 n-1 的二进制表示中除了这一位之外的所有位都是 1。因此，n & (n-1) 的结果应该为 0。
    }

    public static int log2(int n){
        int count=0;
        for (int i = 1; i <=n; i*=2) {
            if (i==n){
                return count;
            }
            count++;
        }
        return -1;
    }
}
