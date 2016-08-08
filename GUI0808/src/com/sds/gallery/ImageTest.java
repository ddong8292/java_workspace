/*
 * 자바의 모든 GUI 컴포넌트는 스스로 그림의 주체가 되어 스스로를 그린다. 이떄 그림 그리는 행위는
 * paint 메서드로 표현되며, 이 paint 메서드의 매개변수로 팔레트역할의 객체인 Graphics 객체가 인수로 전달되어 진다.
 * ex)버튼이 스스로 그림을 증명.
 * */
package com.sds.gallery;

import java.awt.Canvas;//아무것도 그려져 있지 않은 도화지 캔버스.

import javax.swing.JButton;
import javax.swing.JFrame;

public class ImageTest extends JFrame{
	MyButton bt;
	MyCanvas can;
	
	public ImageTest(){
		bt=new MyButton("커스텀 버튼");
		can= new MyCanvas();
		
		
		add(bt);
		add(can);
		setSize(300, 400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	public static void main(String[] args) {
		new ImageTest();
	}

}
