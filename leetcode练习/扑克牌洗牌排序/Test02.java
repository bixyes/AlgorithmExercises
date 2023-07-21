package com.itheima.test07;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test02 {
    public static void main(String[] args) {
        List<String> player1 = new ArrayList<>(); // 玩家1的牌
        List<String> player2 = new ArrayList<>(); // 玩家2的牌
        List<String> player3 = new ArrayList<>(); // 玩家3的牌
        List<String> dipai = new ArrayList<>(); // 底牌

        // 创建一个包含54张牌的List集合
        List<String> poker = new ArrayList<>();
        // 定义两个数组，一个数组存储牌的花色，一个数组存储牌的点数
        String[] colors = {"♠", "♥", "♣", "♦" };
        String[] numbers = {"2", "A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3" };
        // 循环嵌套遍历两个数组，组装52张普通牌
        for (String number : numbers) {
            for (String color : colors) {
                // 把组装好的牌存储到poker集合中
                poker.add(color + number);
            }
        }
        // 添加大小王到poker集合中
        poker.add("大王");
        poker.add("小王");
        // 打乱poker集合中元素的顺序
        Collections.shuffle(poker);
        // 遍历poker集合，把前51张牌分配给3个玩家集合，剩余3张作为底牌
        for (int i = 0; i < poker.size(); i++) {
            // 获取每一张牌
            String card = poker.get(i);
            // 轮流发给不同的玩家
            if (i >= 51) {
                // 给底牌集合发牌
                dipai.add(card);
            } else if (i % 3 == 0) {
                // 给玩家1发牌
                player1.add(card);
            } else if (i % 3 == 1) {
                // 给玩家2发牌
                player2.add(card);
            } else if (i % 3 == 2) {
                // 给玩家3发牌
                player3.add(card);
            }
        }

        // 看玩家1的牌
        System.out.println("玩家1的牌：");
        for (String card : player1) {
            System.out.print(card + " ");
        }
        System.out.println();
        // 看玩家2的牌
        System.out.println("玩家2的牌：");
        for (String card : player2) {
            System.out.print(card + " ");
        }
        System.out.println();
        // 看玩家3的牌
        System.out.println("玩家3的牌：");
        for (String card : player3) {
            System.out.print(card + " ");
        }
        System.out.println();
        // 看底牌
        System.out.println("底牌：");
        for (String card : dipai) {
            System.out.print(card + " ");
        }
        System.out.println();

        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
//                // 其他情况，按照点数大小比较，花色不影响
//                // 截取字符串的最后一个字符作为点数
                String number1 = o1;
                String number2 = o2;
                if (!o1.substring(1).equals("王")) {
                    number1 = o1.substring(1);
                }
                if (!o2.substring(1).equals("王")) {
                    number2 = o2.substring(1);
                }
                // 定义一个数组，存储点数对应的大小顺序
                String[] numbers = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2","小王","大王"};
                // 遍历数组，找到点数对应的索引值，索引值越大，点数越大
                int index1 = -1;
                int index2 = -1;
                for (int i = 0; i < numbers.length; i++) {
                    if (numbers[i].equals(number1)) {
                        index1 = i;
                    }
                    if (numbers[i].equals(number2)) {
                        index2 = i;
                    }
                }
                // 比较索引值，返回结果
                return index1 - index2;
            }
        };

        // 对每个玩家的牌和底牌进行排序
        Collections.sort(player1, comparator);
        Collections.sort(player2, comparator);
        Collections.sort(player3, comparator);
        Collections.sort(dipai, comparator);

        System.out.println(player1);
        System.out.println(player2);
        System.out.println(player3);
        System.out.println(dipai);
    }
}
