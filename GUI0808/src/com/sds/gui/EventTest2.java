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
		bt=new JButton("��ư");
		tf=new JTextField(10);
		
		setLayout(new FlowLayout());
		setSize(300, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	
		add(tf);
		add(bt);
		
	
		//��ư�� �����ʿ��� ����!
		bt.addActionListener(ms=new MyListener());
	
		System.out.println("setEt() �޼��� ȣ���� ���ּҰ�"+this);
		ms.setEt(this);//call by reference
	}
	public static void main(String[] args) {
		new EventTest2();

	}

}
