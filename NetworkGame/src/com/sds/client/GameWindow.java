package com.sds.client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameWindow extends JFrame implements ActionListener{
	JPanel p_north;
	JButton[] btn = new JButton[4];
	JPanel[] page=new JPanel[4];
	Color[] bg={Color.RED, Color.YELLOW, Color.GREEN, Color.ORANGE};
	
	JPanel p_content;
	
	public GameWindow() {
		p_north = new JPanel();
		p_content = new JPanel();
		
		for(int i=0;i<btn.length;i++){
			btn[i] = new JButton(i+"번째 메뉴");
			btn[i].addActionListener(this);
			
			p_north.add(btn[i]);
			
			page[i] = new JPanel();
			page[i].setBackground(bg[i]);
			page[i].setPreferredSize(new Dimension(450, 450));
			page[i].setVisible(false);
			p_content.add(page[i]);
		}
		
		add(p_north, BorderLayout.NORTH);
		add(p_content);
		
		page[0].setVisible(true);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(450,500);
		setVisible(true);		
	}
	public void actionPerformed(ActionEvent e) {
		
	}
	public static void main(String[] args) {
		new GameWindow();

	}

}
