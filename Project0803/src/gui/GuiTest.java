/*
	자바도 다른 응용프로그램처럼, GUI를 지원한다.
	예) 윈도우, 버튼, 체크박스, TextArea 등등을 지원.
	자바에서 GUI컴포넌트는 awt패키지에서 지원한다
*/
package gui;
import java.awt.Frame;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Checkbox;
import java.awt.TextField;
import java.awt.TextArea;
import java.awt.Choice;
class GuiTest{
	
	public static void main(String[] args){
		//모든 GUI 컴포넌트가 올려질 윈도우 창
		//자바에서 프로임은 디폴트속성이 존재하는데 기본이 보이지 않는 속성을 가지고 있다. 따라서 보이게 하자!
		Frame win=new Frame();
		win.setVisible(true);//보이게 하기
		win.setSize(700,700);
		win.setTitle("나 윈도우");
		
		Button bt=new Button("click");		
		
		//자바언어도 html처럼 각 컴퓨넌트를 부착하기에 앞서 어디에 어떻게 붙일지에 대한 디자인 기능이 지원된다! 
		//이 예제에서는 무시하고 가겠다
		FlowLayout flow=new FlowLayout();
		win.setLayout(flow);//배치 방법을 결정하는 메서드
		//버튼을 프레임에 부착!
		win.add(bt);
		
		//자바에서는 객체형도 자료형이다. 따라서 배열도 얼마든지 가능하다 String[] args
		Checkbox[] ch=new Checkbox[20];
			for(int i=0;i<20;i++){
			Checkbox c = new Checkbox(i+"번째 박스");
			ch[i]=c;
			win.add(ch[i]);
			}
		TextField tf=new TextField(20);
			win.add(tf);
		TextArea ta=new TextArea(10,10);//rows-가로, columns-세로
			win.add(ta);
		Choice co=new Choice();
			for(int i=1; i<=12; i++){
				co.add(Integer.toString(i));
			}
			win.add(co);
	}
}
