package com.sds.gallery;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Gellery extends JFrame implements ActionListener{
	JPanel p;
	JButton bt1;
	JButton bt2;
	JTextField txt;
	XCanvas can;
	
	public Gellery(){
		can= new XCanvas();
		p=new JPanel();		
		bt1=new JButton("◁");
		bt2=new JButton("▷");
		txt=new JTextField(30);
		
		p.add(bt1);
		p.add(txt);
		p.add(bt2);
		
		add(p,BorderLayout.SOUTH);
		add(can);

		//리스터와 버튼 연결
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		
		setSize(700, 800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	//이전 이미지 보여주기
	public void prev(){
		//JOptionPane.showMessageDialog(this, "이전 이미지");
		
		
		if(can.count<can.path.length-1){
			can.count--;
			can.repaint();
			JOptionPane.showMessageDialog(this, "이전사진이 없습니다");		
		}
	
	}
	//다음 이미지 보여주기
	public void next(){
		//JOptionPane.showMessageDialog(this, "다음 이미지");
		//XCanvas가 보유한 count 변수를 1증가!
		
		can.count++;
		//다시 그려지기 요청! repaint()->update()화면지움-->paint()다시 그림
		can.repaint();
		if(can.count>can.path.length-1){
			JOptionPane.showMessageDialog(this, "다음사진이 없습니다");
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj=e.getSource();//이벤트 일으킨 컴포넌트 반환!!
		if(obj.equals(bt1)){//이전 버튼이라면..
			prev();
		}else if(obj==bt2){//다음 버튼이라면..
			next();
		}
	}

	public static void main(String[] args) {
		new Gellery();
		
	}
}
