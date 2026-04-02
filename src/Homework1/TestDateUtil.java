package Homework1;
import java.util.Scanner;

public class TestDateUtil {
    public static void main(String[] args){
        System.out.print("请输入今天的日期（格式为20260325）：");
        Scanner in = new Scanner(System.in);
        int input = in.nextInt();
        int year = input / 10000;
        int month = input % 10000 / 100;
        int day = input % 100;
        System.out.print(DateUtil.formatDate(year, month, day));
        if (DateUtil.isLeapYear(year)){
            System.out.println(year+ "年是闰年。");
        }else System.out.println(year+ "年不是闰年。");
        System.out.println(year+ "年" + month +"月的日历：");
        DateUtil.printCalendar(year, month);
        System.out.print("\n");
        System.out.println(year+ "年的日历：");
        DateUtil.printCalendar(year);
        System.out.print("\n");


    }

}
