package com.sds.thread;

import java.awt.Canvas;

public class Bullet extends Thread{
	int x;
	
	Canvas can;
	
	public Bullet(Canvas can) {
		this.can=can;
	}
	
	public void run() {
		while(true){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			x+=5;	
			can.repaint();
		}
	}
	
}
