package com.sds.thread;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

//�����带 ��ӹ޾� ����Ϸ��Ҷ�, �̹� �������� �ڽ� Ŭ������� Runable �������̽��� �̿��� �� �ִ�.
//Runnable�� run�޼��带 �߻�޼���� ������ �������̽��̴�!
public class CounterApp extends JFrame implements Runnable{
	JButton bt;
	JLabel lab;
	Thread thread;//�����͸�����
	int count;
	CounterApp app;
	Thread thread2;//Runnable�� �����尡 �ƴϹǷ�  run�޼��带 ������ �ߴ��� �����尡 �����ؾ� �Ѵ�!
	
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
	//�� run�޼��� Runnable �������̽�����!
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
