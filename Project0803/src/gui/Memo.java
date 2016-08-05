/*
	메모장의 디자인만 따라하자.. 첫날이니깐.
*/
package gui;
import java.awt.Frame;
import java.awt.MenuBar;
import java.awt.Menu;
import java.awt.TextArea;
import java.awt.MenuItem;
class Memo{
	public static void main(String[] args){
		//메모장 윈도우 선언
		Frame frame=new Frame();
		
		//메뉴바 선언
		MenuBar bar= new MenuBar();
		
		//메뉴들
		String[] menuTitle={"파일","편집","서식","보기","도움말"};
		Menu[] m=new Menu[5];
		for(int i=0;i<m.length;i++){
			m[i]=new Menu(menuTitle[i]);
			bar.add(m[i]);//메뉴바에 부착
		}
		//윈도우에 메뉴바 부착!
		frame.setMenuBar(bar);

		//메뉴아이템들
		String[] item={"열기" , "저장", "다른이름으로 저장", "apple", "끝내기"};
		MenuItem[] mi=new MenuItem[5];
		for(int i=0; i<mi.length; i++){
			mi[i]=new MenuItem(item[i]);
			m[0].add(mi[i]);
		}
		
		//TextArea 부착!
		TextArea area= new TextArea(30,40);
		frame.add(area);

		//윈도우 크기, 보이게 하기
		frame.setSize(600,500);
		frame.setVisible(true);

	}
}
