package Homework1;

import java.util.Scanner;

public class CreditCardValidsation {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("请输入你的信用卡号（13-16位的数字）：");
        Long cardNum ;
        try {
            cardNum = in.nextLong();
        } catch (Exception e) {
            System.out.println("输入非法，请输入数字。");
            return;
        }
        int len = 0;
        long cardNumLen =cardNum;//复制一个来测量长度
        while(cardNumLen > 0){
            cardNumLen /= 10;
            len ++;
        }
        if (len >= 13 && len <= 16) {
            if (luhnCheck(cardNum)) {
                System.out.println("该卡号正确。");
            } else {
                System.out.println("该卡号错误。");
            }
        }else System.out.println("输入非法，请重新输入13-16位数字。");
    }



    private static boolean luhnCheck(Long cardNum){
        long num;
        long sum = 0;
        while(cardNum > 0){
            num = cardNum % 10;
            cardNum /= 10;
            sum += num;
            num = cardNum % 10;
            num =2 * num;
            cardNum /= 10;
            if (num > 9){
                sum += num / 10 + num % 10;
            } else sum += num;
        }

        return (sum % 10 == 0);
    }
}
