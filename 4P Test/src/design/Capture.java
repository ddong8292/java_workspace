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
	MenuBar menubar;  //메뉴바
	Menu menuSave ;		//파일저장시키는 메뉴
	Menu menuPen;		//펜을 사용할 수 있는 메뉴
	Menu menuEraser;		//지우개를 사용할 수 있는 메뉴
	Menu menuTxt;		//글자를 삽입 할 수 있는 메뉴
	Menu menuColor;		//색상을 변경시킬 수 있는 메뉴
	Menu menuLoad;		//저장된 이미지파일을 불러오는 메뉴
	Canvas canvas;		//가운데 편집기능이 되는 캔버스(캡처된 이미지)
	ArrayList<Image> arraylist;		//저장된 이미지들의 배열(오른쪽에 보여준다)
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
		
		//1.Robot메서드를 이용하여 화면캡쳐
			//1-1.Robot (GraphicsDevice  screen)
			//1-2. BufferedImage	createScreenCapture (Rectangle  screenRect) 
				//스크린으로부터 읽어내는 픽셀 이미지를 작성합니다.
		//2.canvas에 뿌려준다
	}
	public void saveFile(){//menuFile을 실행하면(누르면) 파일이 저장되는 메서드
		//1.아이콘을 클릭하면 BufferdImage,ImageIO메서드를 사용하여 사진을 저장시킨다.
			
		//2.저장 장소는 default값으로 위치를 지정시켜놓는다.
	}
	public void drawPen(){//menuPen을 실행하면 펜을 사용하게 하는 메서드
		//1.캔버스 내의 moveTo(x,y)를 이용하여 시작점 지정
			
		//2.lineTo(x,y)시작위치(바로 앞 moveTo)에서 지정한 위치까지 선을 그림
		
		//3.stroke()선 출력
	}
	public void useEraser(){//menuEraser를 실행하면 지우개를 사용할 수 있는 메서드
		
	}
	public void inputTxt(){//menuTxt를 실행하면 글자를 삽입하게 하는 메서드
		//1.마우스로 위치를 클릭시 
		//2.그 부분에 커서가 뜨며
		//3.Text를 입력하게 한다.
	}
	public void changeColor(){//menuColor를 사용하여 Pen의 색상을 변경시킬수 있게 하는 메서드
		//1.JColorChooser메서드를 통해 색상을 선택하여 
		//2.pen의 색상을 변경한다.
	}
	public void loadFile(){//menuload를 사용하여 기존에 저장되있던 이미지를 불러오는 메서드
		//1.ImageIO 메서드를 사용하여 
		//2.default 경로의 이미지를 불러온다.
		
	}
	public static void main(String[] args) {
		new Capture();
	}
}
