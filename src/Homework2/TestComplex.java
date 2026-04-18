package Homework2;

public class TestComplex {
    public static void main(String[] args){
        Complex c1 = new Complex(2, 1);
        Complex c2 = new Complex(2.0,1.00);
        //测试toString
        System.out.println("c1 = "+ c1.toString());
        System.out.println("c2 = "+ c2.toString());
        //测试equals
        if(c1.equals(c2)){
            System.out.println("c1和c2相等");
        }else System.out.println("c1和c2不相等");
        //测试getReal() getImg()
        System.out.printf("c1的实部是：%.3f 虚部是: %.3f\n",c1.getReal(), c1.getImag());
        //测试set
        c1.setReal(6);
        c1.setImag(12);
        System.out.println("c1 = "+ c1.toString());
        //测试abs()
        System.out.printf("c1的幅度是: %f\n",c1.abs());
        c2.setValue(5, 0);
        System.out.println("c2 = "+ c2.toString());
        System.out.printf("c2的幅度是: %f\n",c2.abs());
        //测试isReal() isImaginary()
        if(c1.equals(c2.getReal(), c2.getImag())){
            System.out.println("c1和c2相等");
        }else System.out.println("c1和c2不相等");
        if(c2.isReal()){
            System.out.println(c2.toString() + "是实数");
        }else if(c2.isImaginary()){
            System.out.println(c2.toString() + "是纯虚数");
        }else {
            System.out.println(c2.toString() + "是复数");
        }
        if(c1.isReal()){
            System.out.println(c1.toString() + "是实数");
        }else if(c1.isImaginary()){
            System.out.println(c1.toString() + "是纯虚数");
        }else {
            System.out.println(c1.toString() + "是复数");
        }
        //测试加减乘除
        System.out.println(c1.toString()+ "+" + c2.toString() + "=" + c1.add(c2).toString());
        System.out.println(c1.toString()+ "-" + c2.toString() + "=" + c1.subtract(c2).toString());
        System.out.println(c1.toString()+ "×" + c2.toString() + "=" + c1.multiply(c2).toString());
        System.out.println(c1.toString()+ "÷" + c2.toString() + "=" + c1.divide(c2).toString());

    }
}
