package Homework0;

public class Distance {
    public static  void main(String[] args){
        int x = Integer.parseInt(args[0]);
        int y = Integer.parseInt(args[1]);
        double square = x*x + y*y;
        double d = Math.sqrt(square);
        System.out.printf("Distance: %.3f" ,d);
    }

}
