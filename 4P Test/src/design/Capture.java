package design;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javafx.scene.canvas.Canvas;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.image.Image;

public class Capture extends JFrame{
	MenuBar menubar;  //�޴���
	Menu menuSave ;		//���������Ű�� �޴�
	Menu menuPen;		//���� ����� �� �ִ� �޴�
	Menu menuEraser;		//���찳�� ����� �� �ִ� �޴�
	Menu menuTxt;		//���ڸ� ���� �� �� �ִ� �޴�
	Menu menuColor;		//������ �����ų �� �ִ� �޴�
	Menu menuLoad;		//����� �̹��������� �ҷ����� �޴�
	Canvas canvas;		//��� ��������� �Ǵ� ĵ����(ĸó�� �̹���)
	ArrayList<Image> arraylist;		//����� �̹������� �迭(�����ʿ� �����ش�)
	JPanel p_north, p_center;
	public void capture(){
		menubar=new MenuBar();
		//menuFile=new Menu("Save");
		menuPen=new Menu("Pen");
		menuEraser=new Menu("Eraser");
		menuTxt=new Menu("Text");
		menuColor=new Menu("Color");
	//	menuload=new Menu("Load");
		canvas=new Canvas();
		
		//menubar=new MenuBar(menuFile, menuPen, menuEraser,menuTxt,menuColor,menuload);
		
		p_center=new JPanel();
		
		add(p_center);
		
		setSize(1000,1000);
		setBackground(Color.YELLOW);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		//1.Robot�޼��带 �̿��Ͽ� ȭ��ĸ��
			//1-1.Robot (GraphicsDevice  screen)
			//1-2. BufferedImage	createScreenCapture (Rectangle  screenRect) 
				//��ũ�����κ��� �о�� �ȼ� �̹����� �ۼ��մϴ�.
		//2.canvas�� �ѷ��ش�
	}
	public void saveFile(){//menuFile�� �����ϸ�(������) ������ ����Ǵ� �޼���
		//1.�������� Ŭ���ϸ� BufferdImage,ImageIO�޼��带 ����Ͽ� ������ �����Ų��.
			
		//2.���� ��Ҵ� default������ ��ġ�� �������ѳ��´�.
	}
	public void drawPen(){//menuPen�� �����ϸ� ���� ����ϰ� �ϴ� �޼���
		//1.ĵ���� ���� moveTo(x,y)�� �̿��Ͽ� ������ ����
			
		//2.lineTo(x,y)������ġ(�ٷ� �� moveTo)���� ������ ��ġ���� ���� �׸�
		
		//3.stroke()�� ���
	}
	public void useEraser(){//menuEraser�� �����ϸ� ���찳�� ����� �� �ִ� �޼���
		
	}
	public void inputTxt(){//menuTxt�� �����ϸ� ���ڸ� �����ϰ� �ϴ� �޼���
		//1.���콺�� ��ġ�� Ŭ���� 
		//2.�� �κп� Ŀ���� �߸�
		//3.Text�� �Է��ϰ� �Ѵ�.
	}
	public void changeColor(){//menuColor�� ����Ͽ� Pen�� ������ �����ų�� �ְ� �ϴ� �޼���
		//1.JColorChooser�޼��带 ���� ������ �����Ͽ� 
		//2.pen�� ������ �����Ѵ�.
	}
	public void loadFile(){//menuload�� ����Ͽ� ������ ������ִ� �̹����� �ҷ����� �޼���
		//1.ImageIO �޼��带 ����Ͽ� 
		//2.default ����� �̹����� �ҷ��´�.
		
	}
	public static void main(String[] args) {
		new Capture();
	}
}
