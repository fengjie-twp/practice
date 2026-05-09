package homework3;

import java.awt.Graphics;
import java.awt.Color;

public class MyCircle implements Drawable{
	private int x;
	private int y;
	private int r;
	private Color color;

	//以圆心坐标和半径构造
	MyCircle(int x, int y, int r, Color color){
		this.x = x - r;
		this.y = y + r;
		this.r = r;
		this.color = color;
	}
	//无参构造
	MyCircle(){

	}

	//构造矩形的内接圆(ps:圆会生成在矩形中间位置,若长宽不是偶数则会有些偏差)
	MyCircle(MyRectangle rec){
		this((int)rec.getX() + rec.getWidth() / 2,
				(int) rec.getY() - rec.getHeight() / 2,
				(int)Math.min(rec.getHeight(), rec.getWidth()),
				rec.getColor());

	}

	// 以线段为直径构造圆
	MyCircle(MyLine l){
		this ((l.getX1() + l.getX2())/2 ,
				(l.getY1() + l.getY2()) / 2,
				(int)Math.sqrt((l.getX1()-l.getX2()) * (l.getX1()-l.getX2()) + (l.getY1()-l.getY2()) * (l.getY1()-l.getY2())),
				l.getColor());
	}

	public void draw(Graphics g)
	{
		g.setColor(color);
		g.drawOval(x, y, r, r);
	}
}
