package Homework2.Complex;

import java.util.Scanner;

public class ComplexApp {
    public static void main(String[] args){
        System.out.print(" Enter complex number 1(real and imaginary part):");
        Scanner in = new Scanner(System.in);
        Complex c1 = new Complex(in.nextDouble(),in.nextDouble());
        System.out.print(" Enter complex number 2(real and imaginary part):");
        Complex c2 = new Complex(in.nextDouble(),in.nextDouble());
        System.out.println(" Number 1 is:" + c1.toString());
        if(c1.isReal()){
            System.out.println(c1.toString() + "is a pure real number");
        }else System.out.println(c1.toString() + "is NOT a pure real number");
        if(c1.isImaginary()){
            System.out.println(c1.toString() + "is a pure imaginary number");
        }System.out.println(c1.toString() + "is NOT a pure imaginary number");
        System.out.println(" Number 2 is:" + c2.toString());
        if(c2.isReal()){
            System.out.println(c2.toString() + "is a pure real number");
        }System.out.println(c2.toString() + "is NOT a pure real number");
        if(c2.isImaginary()){
            System.out.println(c2.toString() + "is a pure imaginary number");
        }System.out.println(c2.toString() + "is NOT a pure imaginary number");
        if(c1.equals(c2)){
            System.out.println(c1.toString()+"is equal to"+c2.toString());
        }else System.out.println(c1.toString()+"is NOT equal to"+c2.toString());
        System.out.println(c1.toString()+"+"+c2.toString() + "=" + c1.add(c2).toString());
    }

}
