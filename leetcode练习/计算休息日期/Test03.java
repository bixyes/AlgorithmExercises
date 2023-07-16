package com.itheima.test03;

import sun.util.resources.LocaleData;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Test03 {
    //1、请你开发一个程序，当小花输入年以及月后，立即显示出该月份的休息日详情。
    //示范（注意：示范信息重点在于参考格式，结果不一定是准确的，请自行确保计算结果正确性）：
    //**请小花输入查询的月份（月份必须是2022年2月之后的月份）： 2023-5 。**
    //**2023-5-1[休息]   2023-5-2   2023-5-3  2023-5-4[休息] ...**
    //2、显示出该月份哪些休息日是周六或周日（请依次列出具体的日期和其星期信息）。
    public static void main(String[] args) {
       restDay("2022-2");
    }
    public static void restDay(String date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("y-M-d");
        LocalDate firstDate = LocalDate.parse("2022-2-3", formatter);
        System.out.println(firstDate);
        date = date+"-1";
        LocalDate inputDate = LocalDate.parse(date,formatter);
        if (inputDate.isBefore(firstDate.plusMonths(-1))){
            System.out.println("请输入2022-2-3以后的日期");
            return;
        }
//        System.out.println(inputDate);
//        System.out.println(inputDate.plusDays(1));
//        System.out.println(inputDate.getDayOfWeek());
        //存放休息天
        ArrayList<LocalDate> restDays = new ArrayList<>();
        //记录输入日期到首次休息日期的时间间隔
        System.out.println(ChronoUnit.MONTHS.between(firstDate, inputDate));
        long days = ChronoUnit.DAYS.between(firstDate, inputDate);
        //System.out.println(days);
        //System.out.println(inputDate.lengthOfMonth());
        System.out.println("该月的休息日期为：");
        for (int i = 0 ; i < inputDate.lengthOfMonth(); i++) {
            if ((days+i)%3==0){
                System.out.print(inputDate.plusDays(i)+"[休息]\t");
                restDays.add(inputDate.plusDays(i));
            }else {
                System.out.print(inputDate.plusDays(i)+"\t");
            }
        }
        System.out.println();
        System.out.println("休息日是周六和周日的日期是：");
        for (int i = 0; i < restDays.size(); i++) {
            if (restDays.get(i).getDayOfWeek().equals(DayOfWeek.SUNDAY)){
                System.out.println(restDays.get(i)+"[周日]\t");
            }
            if (restDays.get(i).getDayOfWeek().equals(DayOfWeek.SATURDAY)){
                System.out.println(restDays.get(i)+"[周六]\t");
            }
        }


    }
}
