package Homework2.Complex;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Mandelbrot {
    static int xmin = -3;
    static int xmax = 3;
    static int ymin = -2;
    static int ymax = 2;
    static int column = 768;
    static int row = 512;
    static int max = 255;
    public static void main(String[] args) throws FileNotFoundException{
        Picture p = new Picture(column, row);
        Color[] palette = loadPalette("colorlist.txt");
        for (int i = 0; i < column; i++){
            for(int j = 0; j < row; j++){
                Complex z0 = change(i, j);
                p.setColor(i, j, palette[getColorRow(z0)]);
            }
        }
        //绘图
        p.display();

    }
    //将像素点位转为对应复数
    public static Complex change (int w, int h){
        Complex zz = new Complex();
        zz.setReal(xmin + (float)w * (xmax - xmin) / (column - 1) );
        zz.setImag(ymax - (float)h * (ymax - ymin) / (row - 1));
        return zz;
    }
    //根据复数特点返回该位置对应colorlist的行数
    public static int getColorRow (Complex z0){
        Complex z = new Complex();
        z.setValue(z0);
        for(int i = 0; i < max; i++){
            if (z.abs() > 2){
            return i;
            }else z = z.multiply(z).add(z0);
        }
        return max;
    }
    private static Color[] loadPalette (String filename) throws FileNotFoundException{
        Color[] palette = new Color[max + 1];
        Scanner in = new Scanner(new File(filename));

        for (int i = 0; i < max + 1; i++) {
            if(!in.hasNext()){
                in.close();
                throw new IllegalArgumentException("colorlist.txt 行数不够或格式不对：需要至少 256 行，每行 3 个整数");
            }
            int r = in.nextInt();
            int g = in.nextInt();
            int b = in.nextInt();
            palette[i] = new Color(r, g, b);
        }
        in.close();
        return palette;
    }
}
