package com.sds.gallery;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Gallery extends JFrame implements ActionListener{
	XCanvas can;
	JPanel p;
	JButton bt_prev;
	JButton bt_next;
	JTextField txt;
	
	public Gallery() {
		can = new XCanvas();
		p = new JPanel();
		bt_prev = new JButton("이전");
		bt_next = new JButton("다음");
		txt = new JTextField(30);
		
		add(can);
		p.add(bt_prev);
		p.add(txt);
		p.add(bt_next);
		
		add(p, BorderLayout.SOUTH);
		
		//리스너와 버튼 연결 
		bt_prev.addActionListener(this);
		bt_next.addActionListener(this);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(700,650);
		setVisible(true);
	}
	
	//이전 이미지 보여주기
	public void prev(){
		can.count--;
		can.repaint();
	}
	
	//다음 이미지 보여주기
	public void next(){
		//JOptionPane.showMessageDialog(this, "다음 이미지!");
		//XCanvas가 보유한 count 변수를 1증가!!
		can.count++;
		//다시 그려지기 요청~~ 
		//repaint() --> update() 화면지움 -->paint() 다시 그림
		can.repaint();
	}
	
	public void actionPerformed(ActionEvent e) {
		Object obj=e.getSource(); //이벤트를 일으킨 컴포넌트 반환!!
		
		if(obj.equals(bt_prev)){ //이전 버튼이라면...
			prev();
		}else if(obj == bt_next){ //다음 버튼이라면..
			next();
		}
	}
	
	public static void main(String[] args) {
		new Gallery();
	}

}







