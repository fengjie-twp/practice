package Homework1;

import java.util.Scanner;

public class CreditCardVerification {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("请输入你的信用卡号（13-16位的数字）：");
        String cardNum = in.nextLine();
        if (!isValid(cardNum)){
            System.out.println("输入的卡号不合规，请重新输入。");
        }
        else {

            if (luhnCheck(cardNum)) {
                System.out.println("该卡号正确。");
            } else {
                System.out.println("该卡号错误。");
            }
        }
    }

    private static boolean isValid(String cardNum){
        if (cardNum == null || cardNum.isEmpty()){
            return false;
        }
        //判断是否都是13-16位的数字
        return cardNum.matches("^\\d{13,16}$");
    }

    private static boolean luhnCheck(String cardNum){
        int len = cardNum.length();
        int num;
        char c;
        int sum = 0;
        for(int i = len-1; i >= 0;i --){
            c = cardNum.charAt(i);
            num = c - '0';
            sum += num;
            i--;
            if (i == -1){
                break;
            }
            c = cardNum.charAt(i);
            num =2 * (c - '0');
            if (num > 9){
                sum += num / 10 + num % 10;
            } else sum += num;
        }
        return (sum % 10 == 0);
    }


}
