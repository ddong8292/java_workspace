package com.sds.stream;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.LayoutManager;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Editor extends JFrame{
	JPanel p_big, p_top, p_left, p_center;
	JLabel la_1,la_2,la_3,la_4,la_5,la_6,la_7,la_8,la_9,la_10;
	JMenuBar menu;
	JScrollPane scroll;
	JTextArea area;
	JMenu me_1,me_2,me_3,me_4,me_5,me_6,me_7,me_8,me_9,me_10;
	JMenuItem it_1,it_2,it_3,it_4,it_5,it_6,it_7,it_8;
	public Editor(){
		p_big=new JPanel();
		area=new JTextArea();
		p_top=new JPanel();
		p_left=new JPanel();
		p_center=new JPanel();
		
		la_1=new JLabel("1");
		la_2=new JLabel("2");
		la_3=new JLabel("3");
		la_4=new JLabel("4");
		la_5=new JLabel("5");
		la_6=new JLabel("6");
		la_7=new JLabel("7");
		la_8=new JLabel("8");
		la_9=new JLabel("9");
		la_10=new JLabel("10");
		
		me_1=new JMenu("파일");
		me_2=new JMenu("편집");
		me_3=new JMenu("보기");
		me_4=new JMenu("검색");
		me_5=new JMenu("문서");
		me_6=new JMenu("프로젝트");
		me_7=new JMenu("도구");
		me_8=new JMenu("브라우저");
		me_9=new JMenu("창");
		me_10=new JMenu("도움말");
		
		it_1=new JMenuItem("새파일");
		it_2=new JMenuItem("열기");
		it_3=new JMenuItem("닫기");
		it_4=new JMenuItem("------------------------");
		it_5=new JMenuItem("저장");
		it_6=new JMenuItem("새이름으로 저장");
		it_7=new JMenuItem("------------------------");
		it_8=new JMenuItem("종료");
		
		
		menu=new JMenuBar();
		menu.add(me_1);
		menu.add(me_2);
		menu.add(me_3);
		menu.add(me_4);
		menu.add(me_5);
		menu.add(me_6);
		menu.add(me_7);
		menu.add(me_8);
		menu.add(me_9);
		menu.add(me_10);
		
		me_1.add(it_1);
		me_1.add(it_2);
		me_1.add(it_3);
		me_1.add(it_4);
		me_1.add(it_5);
		me_1.add(it_6);
		me_1.add(it_7);
		me_1.add(it_8);
		
		
		
		p_center.add(p_left, BorderLayout.WEST);
		p_top.add(menu);
		add(p_top, BorderLayout.NORTH);
		area.setPreferredSize(new Dimension(700, 650));
		p_left.setPreferredSize(new Dimension(20, 650));
		p_left.setBackground(Color.WHITE);
		p_top.setBackground(Color.WHITE);
		p_left.setLayout(new FlowLayout());
		
		
		p_left.add(la_1);
		p_left.add(la_2);
		p_left.add(la_3);
		p_left.add(la_4);
		p_left.add(la_5);
		p_left.add(la_6);
		p_left.add(la_7);
		p_left.add(la_8);
		p_left.add(la_9);
		p_left.add(la_10);
		
		
		p_center.add(area, BorderLayout.CENTER);
		
		scroll=new JScrollPane(p_center);
		add(scroll, BorderLayout.CENTER);
		
		setSize(800,700);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	public static void main(String[] args) {
		new Editor();
	}

}
