package design;

import java.util.ArrayList;

import javafx.scene.canvas.Canvas;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.image.Image;

public class Capture {
	MenuBar menubar;  //�޴���
	Menu menuFile ;		//���������Ű�� �޴�
	Menu menuPen;		//���� ����� �� �ִ� �޴�
	Menu menuEraser;		//���찳�� ����� �� �ִ� �޴�
	Menu menuTxt;		//���ڸ� ���� �� �� �ִ� �޴�
	Menu menuColor;		//������ �����ų �� �ִ� �޴�
	Menu mebuload;		//����� �̹��������� �ҷ����� �޴�
	Canvas canvas;		//��� ��������� �Ǵ� ĵ����(ĸó�� �̹���)
	ArrayList<Image> arraylist;		//����� �̹������� �迭(�����ʿ� �����ش�)
	
	public void capture(){
		//1.Robot�޼��带 �̿��Ͽ� ȭ��ĸ��
		//2.
	}
	public void saveFile(){//menuFile�� �����ϸ�(������) ������ ����Ǵ� �޼���
		//1.
		//2. ȭ���� â�� ���
		//3.��θ� �����ϰ�
	}
	public void drawPen(){//menuPen�� �����ϸ� ���� ����ϰ� �ϴ� �޼���
		//1. ���콺 �巹�� �� �� ���� �Է��ϰ� �Ѵ�.
	}
	public void useEraser(){//menuEraser�� �����ϸ� ���찳�� ����� �� �ִ� �޼���
		
	}
	public void inputTxt(){//menuTxt�� �����ϸ� ���ڸ� �����ϰ� �ϴ� �޼���
		
	}
	public void changeColor(){//menuColor�� ����Ͽ� Pen�� ������ �����ų�� �ְ� �ϴ� �޼���
		
	}
	
	public void loadFile(){//menulad�� ����Ͽ� ������ ������ִ� �̹����� �ҷ����� �޼���
		
		
	}
	
}
