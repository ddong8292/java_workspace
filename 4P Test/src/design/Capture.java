package design;

import java.util.ArrayList;

import javafx.scene.canvas.Canvas;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.image.Image;

public class Capture {
	MenuBar menubar;  //메뉴바
	Menu menuFile ;		//파일저장시키는 메뉴
	Menu menuPen;		//펜을 사용할 수 있는 메뉴
	Menu menuEraser;		//지우개를 사용할 수 있는 메뉴
	Menu menuTxt;		//글자를 삽입 할 수 있는 메뉴
	Menu menuColor;		//색상을 변경시킬 수 있는 메뉴
	Menu mebuload;		//저장된 이미지파일을 불러오는 메뉴
	Canvas canvas;		//가운데 편집기능이 되는 캔버스(캡처된 이미지)
	ArrayList<Image> arraylist;		//저장된 이미지들의 배열(오른쪽에 보여준다)
	
	public void capture(){
		//1.Robot메서드를 이용하여 화면캡쳐
		//2.
	}
	public void saveFile(){//menuFile을 실행하면(누르면) 파일이 저장되는 메서드
		//1.
		//2. 화면을 창을 띄워
		//3.경로를 설정하고
	}
	public void drawPen(){//menuPen을 실행하면 펜을 사용하게 하는 메서드
		//1. 마우스 드레그 할 때 선을 입력하게 한다.
	}
	public void useEraser(){//menuEraser를 실행하면 지우개를 사용할 수 있는 메서드
		
	}
	public void inputTxt(){//menuTxt를 실행하면 글자를 삽입하게 하는 메서드
		
	}
	public void changeColor(){//menuColor를 사용하여 Pen의 색상을 변경시킬수 있게 하는 메서드
		
	}
	
	public void loadFile(){//menulad를 사용하여 기존에 저장되있던 이미지를 불러오는 메서드
		
		
	}
	
}
