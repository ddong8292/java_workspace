/*
 * 클래스안에 클래스를 둘 수 있는가? 있다.
 * 
 * */
package com.sds.ocjp;

import java.awt.Canvas;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class AnonyTest extends JFrame{
	Canvas can;
	JButton bt1,bt2;
	public AnonyTest(){
		can=new Canvas(){
			@Override
			public void paint(Graphics g) {
				g.drawLine(0, 0, 300, 400);
			}
		};
		bt1=new JButton("버튼1");
		bt2=new JButton("버튼2");
		
		setLayout(new FlowLayout());
		add(bt1);
		add(bt2);
		
		bt1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("난 버튼1");
			}
		});
		
		
		bt2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("난 버튼2");
			}
		});
		
	
		
		add(can);//프레임의 센터에 캔버스 부착!
		setSize(300,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	
	}
	public static void main(String[] args) {
		new AnonyTest();

	}

}
