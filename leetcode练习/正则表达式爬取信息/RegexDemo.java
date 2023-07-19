package com.itheima.d5_regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo {
    public static void main(String[] args) {
        // 定义一个字符串
        String data = "欢迎张全蛋光临本系统！他删库并跑路欢迎李二狗子光临本系统！" +
                " 欢迎马六子光临本系统！它浏览了很多好看的照片！欢迎夏洛光临本系统！他在六点钟送出了一个嘉年华!" ;
        // 定义一个正则表达式
        String regex = "欢迎([\\u4e00-\\u9fa5]+)光临本系统！";
        // 创建一个Pattern对象
        Pattern pattern = Pattern.compile(regex);
        // 创建一个Matcher对象
        Matcher matcher = pattern.matcher(data);
        // 循环查找匹配的子串
        while (matcher.find()) {
            // 获取匹配的人名
            String name = matcher.group(1);
            // 打印人名
            System.out.println(name);
        }
    }
}
