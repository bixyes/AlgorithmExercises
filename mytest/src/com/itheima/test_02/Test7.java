package com.itheima.test_02;

public class Test7 {
    /**
     * 案例七：字符串相加（不做要求，有兴趣的同学自己可以看一下代码逻辑）
     * 给定两个字符串形式的非负整数num1 和num2，计算它们的和并同样以字符串形式返回。
     * 你不能使用任何內建的用于处理大整数的库（比如 BigInteger），也不能直接将输入的字符串转换为整数形式。
     */
    public static void main(String[] args) {
        System.out.println(strAdd("12","23"));
    }
    public static String strAdd(String num1,String num2){
       int number1=strParseInt(num1);
       int number2=strParseInt(num2);

       int sum = number1+number2;

       return sum+"";

    }
    public static int strParseInt(String s){
        int number=0;
        for (int i = 0; i < s.length(); i++) {
            int num=s.charAt(s.length()-1-i)-'0';
             number= number+num*(int) Math.pow(10,i);
        }
        return number;
    }
}
