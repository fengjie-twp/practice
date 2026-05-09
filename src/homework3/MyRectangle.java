package homework3;

import java.awt.Graphics;
import java.awt.Color;

public class MyRectangle implements Drawable{
	private int x;
	private int y;
	private int height;
	private int width;
	private Color color;

	//无参构造
	MyRectangle(){

	}

	//根据顶点坐标和长宽构造
	MyRectangle(int x, int y, int height, int width, Color color){
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
		this.color = color;
	}

	//根据一条线段构造,以该条线段为对角线
	MyRectangle(MyLine l){
		this.x = Math.min(l.getX1(), l.getX2());
		this.y = Math.min(l.getY1(), l.getY2());
		this.width = Math.abs(l.getX1() - l.getX2());
		this.height = Math.abs(l.getY1() - l.getY2());
		this.color = l.getColor();
	}

	public void draw(Graphics g)
	{
		g.setColor(color);
		g.drawRect(x, y, width, height);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

	public Color getColor() {
		return color;
	}
}
