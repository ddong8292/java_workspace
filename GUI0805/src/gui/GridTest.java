/*
 * 5가지 배치관리자 중 GridLayout을 학습한다!
 * grid : 격자(모눈종이 형태)
 * 			row(가로칸수)=층수, colum(세로칸수)=호수
 * 			
 * 		java.awt패키지는 os플랫폼에 따라 디자인이 제각각이라서 이를 보완한 GUI패키지를 사용한다!
 * */
package gui;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;

public class GridTest {

	public static void main(String[] args) {
		Frame frame= new Frame();
		
		frame.setLayout(new GridLayout(5,4));
		
		//버튼 20개를 생성하여 제목을 버튼1, 버튼2 하시오.
		
		Button[] bt=new Button[20];
			for(int i=0;i<bt.length; i++){
				bt[i]=new Button("버튼"+i);
				frame.add(bt[i]);//프레임에 버튼 부착!
		}
			frame.setSize(300, 400);
			frame.setVisible(true);
	}
}


