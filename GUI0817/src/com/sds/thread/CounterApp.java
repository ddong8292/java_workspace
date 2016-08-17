package com.sds.thread;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

//쓰레드를 상속받아 사용하려할때, 이미 누군가의 자식 클래스라면 Runable 인터페이스를 이용할 수 있다.
//Runnable은 run메서드를 추상메서드로 보유한 인터페이스이다!
public class CounterApp extends JFrame implements Runnable{
	JButton bt;
	JLabel lab;
	Thread thread;//내부익명으로
	int count;
	CounterApp app;
	Thread thread2;//Runnable은 쓰레드가 아니므로  run메서드를 재정의 했더라도 쓰레드가 존재해야 한다!
	
	public CounterApp(){
		app=this;
		bt=new JButton("Click");
		lab= new JLabel("0");
		
		add(bt, BorderLayout.NORTH);
		add(lab, BorderLayout.CENTER);
		
		lab.setPreferredSize(new Dimension(250,300));
		lab.setFont(new Font("arial black",Font.BOLD, 120));

		thread= new Thread(){
			
			public void run() {
				while(true){
					try {
						thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					count++;
					lab.setText(Integer.toString(count));
				}
			}
			
		};
		
		thread2=new Thread(this);
		
		bt.addActionListener(new ActionListener() {		
			public void actionPerformed(ActionEvent e) {
				//thread= new MyThread(app);				
				//thread.start();
				thread2.start();
			}
		});
		
		setSize(300, 400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void count(){
		count++;
		lab.setText(Integer.toString(count));
		
	}
	//이 run메서는 Runnable 인터페이스꺼다!
	public void run() {
		while(true){
			try {
				thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			count++;
			lab.setText(Integer.toString(count));
		}
	}
		
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new CounterApp();
	}

}
