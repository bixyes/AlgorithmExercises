package com.itheima.test_01;

import java.util.Random;

public class Test {
    public static double[] generateRedPackets(double totalAmount, int packetCount) {
        double[] packets = new double[packetCount];
        Random random = new Random();
        double remainingAmount = totalAmount;
        int remainingCount = packetCount;
        System.out.println(random.nextDouble()*0.99+0.1);
        for (int i = 0; i < packetCount - 1; i++) {
            double max = remainingAmount / remainingCount * 2;
            double amount =  Math.round(random.nextDouble() * max* 100) / 100.0;
            amount = Math.max(0.01, amount);
            packets[i] = amount;
            remainingAmount -= amount;
            remainingCount--;
        }
        packets[packetCount - 1] = remainingAmount;
        return packets;
    }

    public static void main(String[] args) {
        double[] packets = generateRedPackets(100, 5);
        double sum=0;
        for (double packet : packets) {
            sum+=packet;
            System.out.println(packet);
        }
        System.out.println(sum);
    }
}

