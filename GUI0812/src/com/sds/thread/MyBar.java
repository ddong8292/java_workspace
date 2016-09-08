package com.sds.thread;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JProgressBar;

public class MyBar extends JProgressBar implements Runnable{
	int interval; //몇초간격으로 증가할지!!
	int n;
	
	
	public MyBar(int interval) {
		this.interval=interval;
		this.setPreferredSize(new Dimension(380, 50));
		this.setBackground(Color.YELLOW);
	}
	
	public void run() {
		while(true){
			try {
				Thread.sleep(interval);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			n++;
			this.setValue(n);
		}
	}

}
