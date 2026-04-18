package Homework2.Complex;

public class Complex {
    private double real;
    private double imag;
    public static  double EPSILON = 1e-8;
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
        return "("+ real + " + " + imag + "i)";
    }

    public boolean isReal(){
        return imag == 0;
    }

    public boolean isImaginary(){
        return (real == 0 && imag != 0);
    }

    public boolean equals(double real, double imag){
        if (Double.isNaN(real) || Double.isNaN(imag))
            return false;
        return (Math.abs(this.real - real) < EPSILON)
                && (Math.abs(this.imag - imag) < EPSILON);
    }

    public boolean equals(Complex another){
        return (Math.abs(this.real - another.real) < EPSILON)
                && (Math.abs(this.imag - another.imag) < EPSILON);
    }

    public double abs(){
        return Math.sqrt(Math.pow(this.real, 2) + Math.pow(this.imag, 2));
    }

    public Complex add(Complex right){
        Complex c;
        c.real = this.real + right.real;
        c.imag = this.imag + right.imag;
        return c;
    }

    public Complex subtract(Complex right){
        Complex c;
        c.real = this.real - right.real;
        c.imag = this.imag - right.imag;
        return c;
    }

    public Complex multiply(Complex right){
        Complex c;
        c.real = this.real * right.real - this.imag * right.imag;
        c.imag = this.real * right.imag + this.imag * right.real;
        return c;
    }

    public Complex divide(Complex right){
        Complex c;
        double mo = this.abs();
        c.real = (this.real * right.real + this.imag * right.imag) / Math.pow(mo, 2);
        c.imag = (this.real * right.imag - this.imag * right.real) / Math.pow(mo, 2);
        return c;
    }
}
