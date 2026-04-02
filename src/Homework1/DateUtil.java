package Homework1;

public class DateUtil {
    public static boolean isLeapYear(int year){
        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }

    public static boolean isValidDate(int year, int month, int day){
        if (year >= 1 && year  <= 9999){
            if(month < 1 || month > 12){
                return false;
            }else{
                switch (month){
                    case 1:
                    case 3:
                    case 5:
                    case 7:
                    case 8:
                    case 10:
                    case 12:
                        return (day > 0 && day <=31);

                    case 4:
                    case 6:
                    case 9:
                    case 11:
                        return (day > 0 && day <=30);
                    case 2:
                        if(isLeapYear(year)){
                            return (day > 0 && day <=29);
                        }else return (day > 0 && day <=28);
                    default:break;
                }
            }

        }else return false;
        return false;
    }

    public static int getDayOfWeek(int year, int month, int day){
        int sum = 0;
        int[] num ;
        if(isLeapYear(year)){
            num = new int[]{6, 2, 3, 6, 1, 4, 6, 2, 5, 0, 3, 5};
        }else {
            num = new int[]{0, 3, 3, 6, 1, 4, 6, 2, 5, 0, 3, 5};
        }
        switch (year / 100  % 4){
            case 1 :
                sum += 4;
                break;
            case 2 :
                sum += 0;
                break;
            case 3 :
                sum += 2;
                break;
            case 0 :
                sum += 6;
                break;
            default: break;
        }
        sum += year % 100 + year % 100 / 4 + num[month-1] + day;
        int dayOfWeek = sum % 7;
        if(dayOfWeek == 0){
            dayOfWeek = 7;
        }
        return dayOfWeek;
    }

    public static void printCalendar(int year, int month){
        int day = 1;
        int start = getDayOfWeek(year, month, day) -1;
        int[] days;
        if (isLeapYear(year)) {
            days = new int[]{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        }else {
            days = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};}
        int [][] calendar = new int[6][7];
        //int end = getDayOfWeek(year, month, days[month -1]) - 1;
        int week = 0;
        while(day <= days[month - 1]){
            int dayOfWeek = getDayOfWeek(year, month, day);
            calendar[week][dayOfWeek-1] = day;
            day++;
            if (dayOfWeek == 7){
                week ++;
            }
        }
        day --;//减去多加的一次
        System.out.printf("           %d.%02d\n", year, month);
        System.out.println("MON  TUE  WED  THU  FRI  SAT  SUN");
        int i = 0;
        int j = 0;
        //用while循环来控制打印的尾，避免讨论该月需要占几个礼拜
        while(day > 0) {
            //确定打印的开始位置
            if (j < start && i == 0) {
                System.out.print("     ");
                j++;
            } else {
                System.out.printf("%3d  ", calendar[i][j]);
                j++;
                day--;
                if (j == 7){
                    System.out.print("\n");
                    i++;
                    j = 0;
                }
            }
        }
    }


    public static void printCalendar(int year){
        for(int i = 0; i < 12; i++){
            printCalendar(year, i+1);
            System.out.print("\n");
        }
    }
    public static String formatDate(int year, int month, int day){
        String[] week = {"Monday", "Tuesday" ,"Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        String[] months = {"Jan", "Feb", "Mar", "Apr", "Mar", "Jun", "Jul", "Aug", "Sept", "Oct", "Nov", "Dec"};
        if(!isValidDate(year, month, day)){
            return "该日期不合理，请重新输入。\n";
        }else{
            return week[getDayOfWeek(year, month, day) - 1] +
                    "  " + day + "  " + months[month-1] + "  " + year + "\n";
        }
    }
}
