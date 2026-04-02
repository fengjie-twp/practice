package Homework1;

public class PatternPrint {
    public static void main(String[] args){
        //检查命令行的输入
        if(args.length != 2){
        usage();
        return ;
        }
        char mode = args[0].toLowerCase().charAt(0);//将获取的字符串类型转化为char类型
        int n;
        try {
            n = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            System.out.println("Error:应输入整数数字。");
            usage();
            return;
        }
        if (n <= 0 ) {
            System.out.println("Error:应输入正整数。");
            usage();
            return;
        }
        if ( mode < 'a' || mode > 'i') {
            System.out.println("Error:请从a-i中选择一个图形类型。");
            usage();
            return;
        }
        switch (mode) {
            case 'a' -> printA(n);
            case 'b' -> printB(n);
            case 'c' -> printC(n);
            case 'd' -> printD(n);
            case 'e' -> printE(n);
            case 'f' -> printF(n);
            case 'g' -> printG(n);
            case 'h' -> printH(n);
            case 'i' -> printI(n);
            default -> usage();
        }
    }
    //规范格式，多处需用到
    public static void usage(){
        System.out.println("Usage: java PatternPrint <图形类型：a-i> <图形大小：n>");
        System.out.println("Example: java PatternPrint a 8");
    }

    public static void printA(int n){
        for(int i = 1; i <= n; i++){
            for (int j = 1; j <= i ; j++){
                System.out.printf("%-2d",j % 10);
            }
            System.out.print("\n");
        }
    }

    public static void printB(int n){
        for(int i = 1; i <= n; i++){
            for (int j = 1; j <= i - 1; j++){
                System.out.print("  ");
            }
            for (int j = 1; j <= n - i + 1; j++){
                System.out.printf("%-2d",j % 10);
            }
            System.out.print("\n");
        }
    }

    public static void printC(int n){
        for(int i = 1; i <= n; i++){
            for (int j = 1; j <= n - i; j++){
                System.out.print("  ");
            }
            for (int j = i; j > 0; j--){
                System.out.printf("%-2d",j % 10);
            }
            System.out.print("\n");
        }
    }

    public static void printD(int n){
        for(int i = 1; i <= n; i++){
            for (int j = n - i + 1; j >= 1; j--){
                System.out.printf("%-2d",j % 10);
            }
            System.out.print("\n");
        }
    }

    public static void printE(int n){
        for(int i = 1; i <= n; i++){
            for (int j = 1; j <= n - i; j++){
                System.out.print("  ");
            }
            for (int j = 1; j <= i; j++){
                System.out.printf("%-2d",j % 10);
            }
            for (int j = i - 1; j > 0; j--){
                System.out.printf("%-2d",j % 10);
            }
            System.out.print("\n");
        }
    }

    public static void printF(int n){
        for(int i = 1; i <= n; i++) {
            for (int j = 1; j <= i - 1; j++) {
                System.out.print("  ");
            }
            for (int j = 1; j <= n - i + 1; j++) {
                System.out.printf("%-2d", j % 10);
            }
            for (int j = n - i ; j >= 1; j--){
                System.out.printf("%-2d", j % 10);
            }
            System.out.print("\n");
        }
    }

    public static void printG(int n){
        for(int i = 1; i <= n; i++){
            for (int j = 1; j <= i ; j++){
                System.out.printf("%-2d",j % 10);
            }
            for (int j = n - i; j > 0; j--){
                System.out.print("  ");
            }
            for (int j = 1; j < n - i; j++){
                System.out.print("  ");
            }
            if (i == n){
                for (int j = i - 1; j > 0; j--){
                    System.out.printf("%-2d",j % 10);
                }
                System.out.print("\n");
            }else {
                for (int j = i; j > 0; j--){
                    System.out.printf("%-2d",j % 10);
                }
                System.out.print("\n");
            }

        }
    }

    public static void printH(int n){
        for(int i = 1; i <= n; i++){
            for (int j = 1; j <= n - i + 1; j++){
                System.out.printf("%-2d",j % 10);
            }
            for (int j = i - 1; j > 0; j--){
                System.out.print("  ");
            }
            for (int j = i - 1; j > 1; j--){
                System.out.print("  ");
            }
            if (i == 1){
                for (int j = n - i; j > 0; j--) {
                    System.out.printf("%-2d", j % 10);
                }
            }else{
                for (int j = n - i + 1; j > 0; j--){
                    System.out.printf("%-2d",j % 10);
                }
            }
            System.out.print("\n");
        }
    }

    public static void printI(int n){
        for(int i = 1; i <= n; i++){
            for (int j = 1; j <= n - i; j++){
                System.out.print("  ");
            }
            for (int j = i; j <= 2 * i - 1; j++){
                System.out.printf("%-2d", j % 10);
            }
            for (int j = 2 * i - 2; j >= i; j--){
                System.out.printf("%-2d", j % 10);
            }
            System.out.print("\n");
        }
    }
}





