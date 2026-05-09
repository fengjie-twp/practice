package homework3;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;

public class DrawPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	//private MyLine[] lines;
	//private MyCircle[] circles;
	//private MyRectangle[] rectangles;
	//为MyLine MyRectangle MyCircle创建统一的接口Drawble
	private Drawable[] shapes;

//	private int type;
//
//	private static final int NONE = 0;
//	private static final int LINE = 1;
//	private static final int CIRCLE = 2;
//	private static final int RECTANGLE = 3;
//	private static final int NULL = 4;
//	private static final int NOTARRAY = 5;
//
	public DrawPanel()
	{
		setBackground(Color.BLACK);
		//type = NONE;
	}

	//创建统一构造
	public DrawPanel(Drawable[] shapes){
		setBackground(Color.WHITE);
		//保证数组不是null
		if (shapes == null){
			this.shapes = new Drawable[0];
		}else this.shapes = shapes;
	}
//	public DrawPanel(MyLine[] lines)
//	{
//		setBackground(Color.WHITE);
//		if (lines == null)
//		{
//			type = NULL;
//			return;
//		}
//		if (!lines.getClass().isArray())
//		{
//			type = NOTARRAY;
//			return;
//		}
//		this.lines = lines;
//		type = LINE;
//	}
//
//	public DrawPanel(MyCircle[] circles)
//	{
//		setBackground(Color.WHITE);
//		if (circles == null)
//		{
//			type = NULL;
//			return;
//		}
//		if (!circles.getClass().isArray())
//		{
//			type = NOTARRAY;
//			return;
//		}
//		this.circles = circles;
//		type = CIRCLE;
//	}
//
//	public DrawPanel(MyRectangle[] rectangles)
//	{
//		setBackground(Color.WHITE);
//		if (rectangles == null)
//		{
//			type = NULL;
//			return;
//		}
//		if (!rectangles.getClass().isArray())
//		{
//			type = NOTARRAY;
//			return;
//		}
//		this.rectangles = rectangles;
//		type = RECTANGLE;
//	}
//
 	//无需判断类型,直接draw
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		for(Drawable shape : shapes)
			shape.draw(g);
//		switch(type){
//		case LINE:
//			for (MyLine line : lines)
//				line.draw(g);
//			break;
//		case CIRCLE:
//			for (MyCircle circle : circles)
//				circle.draw(g);
//			break;
//		case RECTANGLE:
//			for (MyRectangle rectangle : rectangles)
//				rectangle.draw(g);
//			break;
//		case NULL:
//			g.drawString("在DrawPanel的构造函数中，你传递的引用参数是NULL。", 50, 50);
//			break;
//		case NOTARRAY:
//			g.drawString("在DrawPanle的构造函数中，你传递的引用参数必须是某个形状的数组类型。", 50, 50);
//			break;
		}
	}	

