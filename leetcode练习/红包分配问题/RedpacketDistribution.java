

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Random;

public class Test2 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(luckyMoney("150.01", 10)));
    }

    public static BigDecimal[] luckyMoney(String money,int n){
        double money1= 0;
        try {
            money1 = Double.parseDouble(money);
        } catch (NumberFormatException e) {
            System.out.println("输入金额错误！");
            e.printStackTrace();
            return null;
        }
        System.out.println(money1);
        int total=(int) (money1*100);
        int rest=total-n;
        int restNum=n;
        int[] luckMoney=new int[n];
        Random r = new Random();
        for (int i = 0; i < luckMoney.length; i++) {
            if (i==luckMoney.length-1){
                luckMoney[luckMoney.length-1]=1+rest;
                break;
            }
            if (rest>0){
                int temp=r.nextInt(rest*2/restNum+1);
                restNum--;
                luckMoney[i]=1+temp;
                rest-=temp;
            }else {
                luckMoney[i]=1;
            }
        }
        BigDecimal[] luckMoney1=new BigDecimal[n];
        BigDecimal sum = new BigDecimal("0");
        for (int i = 0; i < luckMoney.length; i++) {
            BigDecimal a = new BigDecimal(""+luckMoney[i]);
            BigDecimal b = new BigDecimal("100");
            luckMoney1[i]= a.divide(b,2,BigDecimal.ROUND_HALF_UP);
            sum=sum.add(luckMoney1[i]);
        }
        System.out.println(sum);
        return luckMoney1;
    }
}
