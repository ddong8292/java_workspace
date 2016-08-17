package com.sds.thread;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class Test extends JFrame{
	JButton bt;
	JLabel lab;
	JPanel pan;
	JProgressBar bar1;
	JProgressBar bar2;
	Thread thread;
	Thread thread2;
	Thread thread3;
	
	int count;
	int count2;
	int count3;
	
	
	public Test() {
		bt= new  JButton("Click");
		lab=new  JLabel("0");
		pan=new JPanel();
		bar1=new JProgressBar();
		bar2=new JProgressBar();
		
		pan.add(bar1, BorderLayout.NORTH);
		pan.add(bar2, BorderLayout.SOUTH);
		
		lab.setPreferredSize(new Dimension(200, 200));
		lab.setFont(new Font("arial black", Font.BOLD, 200));

		
		add(bt, BorderLayout.NORTH);
		add(lab, BorderLayout.CENTER);
		add(pan, BorderLayout.SOUTH);
		
		setSize(400,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		thread=new Thread(){
			
			public void run() {
				while(true){
				try {
					thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				count++;
				lab.setText(Integer.toString(count));
				}
			}
		};
		thread2=new  Thread(){
			@Override
			public void run() {
				while(true){
					try {
						thread2.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					bar1.setValue(count2);
					count2++;
				}
			}
			
		};
		thread3=new Thread(){
			@Override
			public void run() {
				while(true){
					try {
						thread3.sleep(300);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					bar2.setValue(count);
					count3++;
				}
				
			}
			
		};
		
		bt.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				thread.start();
				thread2.start();
				thread3.start();
			}
		});
	}
		
	
	public static void main(String[] args) {
		new Test();
	}

}
