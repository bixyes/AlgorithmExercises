package com.itheima.test03;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        // 目标：手写ArrayList集合
        MyArrayList<String> list = new MyArrayList<>();
        list.add("张无忌");
        list.add("宋青书");
        list.add("周芷若");
        list.add("赵敏");
        list.add("小昭");
        list.add("小昭");
        list.add("小昭");
        list.add("小昭");
        list.add("小昭");
        list.add("小昭10");
        list.add("小昭11");
        System.out.println(list);
        System.out.println(list.size());

        System.out.println(list.remove(4));
        System.out.println(list);
        System.out.println(list.size());

        System.out.println(list.get(1));

        list.forEach(s -> System.out.println(s));
    }
}
