/*
 5가지 배치관리자 중 GridLayout 을 학습한다!!
 grid : 격자 (모눈종이형태) 
          row(가로칸수)=층수 , colum(세로칸수)=호수
          
          java.awt 패키지는 os 플랫폼에 따라 디자인이 제각각
          이라서 이를 보완한 GUI 패키지를 사용한다!! 
 */
package gui;
import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;

import javax.crypto.SecretKeyFactorySpi;
public class GridTest {
	public static void main(String[] args) {
		Frame frame=new Frame();
		GridLayout layout= null;
		frame.setLayout(layout=new GridLayout(3,4));
		
		//버튼 20개를 생성하여 제목을 버튼1,버튼2...하시오..
		Button[] btn = new Button[20];
		
		for(int i=0;i<btn.length;i++){
			btn[i] = new Button("버튼"+i);
			frame.add(btn[i]); //프레임에 버튼 부착!!
		}
		
		frame.setSize(300, 400);
		frame.setVisible(true);
		
	}

}









