package com.sds.thread;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class AnimationApp extends JFrame{
	Canvas can;
	JButton bt;
	Toolkit kit=Toolkit.getDefaultToolkit();
	Image img;
	int x;
	Thread thread;
	public AnimationApp(){
		bt=new JButton("Button");
		img=kit.getImage("C:/java_workspace/GUI0812/res/b.png");
		can= new Canvas(){
			
			public void paint(Graphics g) {
				g.drawImage(img, x, 0, 50, 50, this);
				
			}
		};
		
		//쓰레드 새성
		thread=new Thread(){
			public void run() {
				while(true){
					try {
						thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					move();
				}
			}
			
		};
		
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				thread.start();
			}
		});
		
		setLayout(new BorderLayout());
		
		add(can, BorderLayout.CENTER);
		add(bt, BorderLayout.NORTH);
		
		setSize(900, 800);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void move(){
		x+=10;
		can.repaint();
		
	}
	public static void main(String[] args) {
		new AnimationApp();
	}

}
