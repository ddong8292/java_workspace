package com.sds.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Test extends JFrame {
	JPanel pan;
	JButton bt1;
	JButton bt2;
	JPanel pan2;
	
	public Test(){
		bt1= new JButton("CREATE");
		bt2=new JButton("COLOR");
		pan= new JPanel();
		pan2=new JPanel();
		
		add(pan, BorderLayout.NORTH);
		add(pan);
		pan.add(bt1);
		pan.add(bt2);
		pan2.setLayout(new FlowLayout());
		add(pan);
		
		
		bt1.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				pan2.add(new JButton());
				System.out.println("생성");
			
			}
		});
		bt2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("색 변경");
				
			}
		});
		
		setSize(600,600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}

	public static void main(String[] args) {
		new Test();
	}

}
