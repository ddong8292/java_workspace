package com.sds.thread;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

//쓰레드를 상속받아 사용하려할때, 이미 누군가의 자식 클래스라면, Runnable  
//인터페이스를 이용할 수 있다 
//Runnable 은 run 메서드를 추상메서드로 보유한 인터페이스이다!!
public class CounterApp extends JFrame implements Runnable{
	JButton bt;
	JLabel la_count;
	int count;
	MyThread thread;
	CounterApp app;
	Thread thread2; //내부익명으로...
	Thread thread3; //Runnable 은 쓰레드가 아니므로, run 메서드를
	//재정의하였다 하더라도 쓰레드가 존재해야 한다!!
	
	public CounterApp() {
		app=this;
		bt  =new JButton("시작");
		la_count = new JLabel("0");
		
		setLayout( new FlowLayout());
		
		la_count.setPreferredSize(new Dimension(250, 300));
		la_count.setFont(new Font("arial black", Font.BOLD, 100));
		
		add(bt);
		add(la_count);
		
		thread2= new Thread(){
			public void run(){
				while(true){
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					count++;
					la_count.setText(Integer.toString(count));
				}
			}
		};
		
		thread3=new Thread(this);	
		
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//thread = new MyThread(app);
				//thread.start();
				//thread2.start();
				thread3.start();
			}
		});
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300,400);
		setVisible(true);
	}
	
	//이 run메서드는  Runnable 인터페이스 꺼다!!
	public void run() {
		while(true){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			count++;
			la_count.setText(Integer.toString(count));
		}		
	}
	
	public static void main(String[] args) {
		new CounterApp();
	}

}





