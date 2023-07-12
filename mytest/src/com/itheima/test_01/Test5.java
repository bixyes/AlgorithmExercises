package com.itheima.test_01;

import java.util.Scanner;

public class Test5 {
    private static String username="zhangsan";
    private static String password="123456";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count=3;
        while (true) {
            System.out.println("请输入用户名：");
            String username1 = sc.next();
            System.out.println("请输入登录密码：");
            String password1=sc.next();
            if (count<=1){
                System.out.println("用户名或密码输入错误，账户：XXX被锁定请联系客服");
                return;
            }
            if (!username1.equals(username)||!password1.equals(password)){
                count--;
                System.out.println("用户名或密码输入错误，您还剩下"+count+"次机会");
                continue;
            }
            System.out.println("登录成功");
            return;
        }
    }
}
