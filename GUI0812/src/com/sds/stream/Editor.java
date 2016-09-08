package com.sds.stream;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Editor extends JFrame{
	JPanel p_all;
	JPanel p_line;
	JTextArea area;
	JScrollPane scroll;
	ArrayList<JLabel> list_label; 
	
	public Editor() {
		p_all = new JPanel();
		p_line = new JPanel();
		area = new JTextArea();
		scroll = new JScrollPane(area);
		list_label = new ArrayList<JLabel>();
		
		p_all.setLayout(new BorderLayout());
		
		//왼쪽영역
		//p_line.setBackground(Color.GRAY);
		p_line.setPreferredSize(new Dimension(35,700));
		p_all.add(p_line, BorderLayout.WEST);
		
		//area영역
		area.setBackground(Color.WHITE);
		p_all.add(scroll);
		
		add(p_all);
		
		initLabel();
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800, 700);
		setVisible(true);
	}
	
	public void initLabel(){
		int count=list_label.size();
		for(int i=1;i<=20;i++){
			count++;
			MyLabel la= new MyLabel(i,15);
			p_line.add(la);
		}
	}
	
	public static void main(String[] args) {
		new Editor();
	}

}