package homework3;

import java.awt.Color;
import javax.swing.JFrame;
import java.util.Random;
import java.util.Scanner;

public class TestDraw {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i ;
		while (true) {
			System.out.print("请输入你想看到的图形的序号(1.Line 2.Rectangle 3.Circle):");
			if (sc.hasNextInt()) {
				i = sc.nextInt();
				if (i >= 1 && i <= 3) {
					break;
				} else {
					System.out.println("请输入1、2或3！");
				}
			} else {
				System.out.println("输入的不是整数，请重新输入！");
				// 消耗掉错误输入，避免死循环
				sc.next();
			}
		}
		DrawPanel panelLine = new DrawPanel(generateLines());
		DrawPanel panelCircle = new DrawPanel(generateCircles());
		DrawPanel panelRectangles = new DrawPanel(generateRectangles());
		JFrame application = new JFrame();
		application.setTitle("面向对象程序设计第3次作业");
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		switch (i){
			case 1 -> application.add(panelLine);
			case 2 -> application.add(panelRectangles);
			case 3 -> application.add(panelCircle);
        }
		application.setSize(400, 300);
		application.setVisible(true);
	}
	public static MyLine[] generateLines(){
		Random randomNumber = new Random();
		MyLine[] lines;
		lines = new MyLine[ 10 + randomNumber.nextInt(5)];
		for (int count = 0; count < lines.length; count++)
		{
			int x1 = randomNumber.nextInt(400);
			int y1 = randomNumber.nextInt(300);
			int x2 = randomNumber.nextInt(400);
			int y2 = randomNumber.nextInt(300);
			Color color = new Color( randomNumber.nextInt(256), randomNumber.nextInt(256), 
					randomNumber.nextInt(256));
			lines[count] = new MyLine(x1, y1, x2, y2, color);
		}
		return lines;
	}
	public static MyCircle[] generateCircles(){
		//该函数的功能类似于generateLines，功能是随机的产生不同颜色，不同大小的MyCircle类型对象，并将这些对象汇聚到数组中
		//函数将返回MyCircle类型的数组，该数组可以作为DrawPanel构造函数的参数，从而创建的DrawPanel可以绘制圆形。
		Random randomNumber = new Random();
		MyCircle[] circles;
		//可能是因为定位问题,数组数量在[10 - 15]图形之间效果不好,圆比较少,遂增大数组范围
		circles = new MyCircle[ 25 + randomNumber.nextInt(5)];
		for (int count = 0; count<circles.length; count++)
		{
			int x = randomNumber.nextInt(400);
			int y = randomNumber.nextInt(300);
			int r = randomNumber.nextInt(400);
			Color color = new Color( randomNumber.nextInt(256), randomNumber.nextInt(256),
					randomNumber.nextInt(256));
			circles[count] = new MyCircle(x, y, r, color);
		}
		return circles;

	}
	public static MyRectangle[] generateRectangles(){
		//这个函数的解释见上面函数的解释
		Random randomNumber = new Random();
		MyRectangle[] rectangles;
		rectangles = new MyRectangle[ 10 + randomNumber.nextInt(5)];
		for (int count = 0; count<rectangles.length; count++)
		{
			int x = randomNumber.nextInt(400);
			int y = randomNumber.nextInt(300);
			int height = randomNumber.nextInt(300);
			int width = randomNumber.nextInt(400);
			Color color = new Color( randomNumber.nextInt(256), randomNumber.nextInt(256),
					randomNumber.nextInt(256));
			rectangles[count] = new MyRectangle(x, y, height, width, color);
		}
		return rectangles;
	}

}
