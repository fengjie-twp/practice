package Homework0;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class SortThreeByFile {
    public static void main(String[] args) throws FileNotFoundException{
        int num1 ,num2 ,num3;
        Scanner in = new Scanner(new File(args[0]));
        num1 = in.nextInt();
        num2 = in.nextInt();
        num3 = in.nextInt();
        System.out.printf("%d %d %d\n", num3 ,num2 ,num1);
        in.close();
    }

}
