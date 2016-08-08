package com.sds.gui;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class EventTest2 extends JFrame{
	JButton bt;
	JTextField tf;
	MyListener ms;
	
	public EventTest2(){
		bt=new JButton("버튼");
		tf=new JTextField(10);
		
		setLayout(new FlowLayout());
		setSize(300, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	
		add(tf);
		add(bt);
		
	
		//버튼과 리스너와의 연결!
		bt.addActionListener(ms=new MyListener());
	
		System.out.println("setEt() 메서드 호출전 내주소값"+this);
		ms.setEt(this);//call by reference
	}
	public static void main(String[] args) {
		new EventTest2();

	}

}
