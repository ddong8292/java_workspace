package com.sds.thread;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class Test2 extends JFrame implements KeyListener{
	Canvas can;
	Thread thread;
	int x=0;
	
	public Test2() {
		can= new Canvas(){
			public void paint(Graphics g) {
				g.drawOval(x, 100, 50, 50);
			}
		};
		
		addKeyListener(this);
		
		can.setBackground(Color.CYAN);
		add(can);
		//윈도우를 모니터 크기와 상관없이 항상 가운데 띄우기!!
		setLocationRelativeTo(null);
		setSize(800,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		thread=new Thread(){
		
			public void run() {
				while(true){
					try {
						thread.sleep(5);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					x+=5;
					can.repaint();
				}
		
			}
		};
		
	}
	
	public void keyTyped(KeyEvent e) {
	}	
	public void keyPressed(KeyEvent e) {
	}
	
	public void keyReleased(KeyEvent e) {
		int key=e.getKeyCode();
		if(key==KeyEvent.VK_SPACE){
		thread.start();
		
		}
	}
	
	
	public static void main(String[] args) {
		new Test2();
		
	}


}
