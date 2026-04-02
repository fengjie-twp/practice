package Homework0;

import java.util.Scanner;

public class SortThree {
    public static void main(String[] args){
        int num1 ,num2 ,num3;
        Scanner in = new Scanner(System.in);
        System.out.print("Enter first number: ");
        num1 = in.nextInt();
        System.out.print("Enter second number: ");
        num2 = in.nextInt();
        System.out.print("Enter third number: ");
        num3 = in.nextInt();
        System.out.printf("%d %d %d",num3 ,num2 ,num1);
    }

}
