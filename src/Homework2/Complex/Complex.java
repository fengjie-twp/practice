package Homework2.Complex;

public class Complex {
    private double real;
    private double imag;

    public Complex() {

    }

    public Complex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public double getReal(){
        return real;
    }

    public void setReal(double real){
        this.real = real;
    }

    public double getImag() {
        return imag;
    }

    public void setImag(double imag) {
        this.imag = imag;
    }

    public void setValue(double real, double imag){
        this.real = real;
        this.imag = imag;
    }

    public String toString(){
        return real + imag + "i";
    }

    public boolean isReal(){
        return imag == 0;
    }

    public boolean isImaginary(){
        return (real == 0 && imag != 0);
    }

}
