package com.itheima.test06.lottery.entry;


import com.itheima.test06.lottery.domain.Awards;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Entry {

    public static void main(String[] args) {

        // 定义奖项数组,并为其设置值
        Awards[] awards = new Awards[4] ;
        awards[0] = new Awards("一等奖" , 1) ;
        awards[1] = new Awards("二等奖" , 2) ;
        awards[2] = new Awards("三等奖" , 3) ;
        awards[3] = new Awards("谢谢惠顾" , 4) ;

        // 补全代码
        Random random = new Random();

        //将奖项值按其权重值数量放入集合中
        ArrayList<Integer> list = new ArrayList<>();
        addWeight(awards,list);
        System.out.println(list);
        System.out.println(list.size());

        while (list.size()>0) {
            //获取一个不大于集合索引的随机值
            int rd = random.nextInt(list.size());

            //从集合中随机取出一个权重值
            int num = list.get(rd);

            //将该权重值从集合中删除
            list.remove(rd);


            Awards awards1 = binarySearch(awards, num);

            System.out.println("恭喜XXX先生/女士获得:"+awards1.getName());
        }
    }

    private static void addWeight(Awards[] awards, ArrayList<Integer> list) {
        for (int i = 0; i < awards.length; i++) {
            for (int j = 0; j < awards[i].getWeight(); j++) {
                list.add(awards[i].getWeight());
            }
        }
    }

    // 二分查找实现
    public static Awards binarySearch(Awards[] awards , int num) {
        int left = 0;
        int right = awards.length-1;
        while (left<=right){
            int mid = (left+right)/2;
            if (num>awards[mid].getWeight()){
                left = mid+1;
            }
            if (num<awards[mid].getWeight()){
                right = mid-1;
            }
            if (num == awards[mid].getWeight()){
                return awards[mid];
            }
        }
        return null;
    }

}
