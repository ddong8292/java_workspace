package com.sds.thread;

import com.sds.thread.CounterApp;

public class MyThread extends Thread{
	//�����ڴ� ���������� �����ϰ� ���� �ڵ带  run�޼��忡 �ۼ��ؾ� �Ѵ�.
	 
	int count=0;
	CounterApp app;//null
	public  MyThread(CounterApp app){
		this.app=app;
		
	}
	
	public void run(){
		while(true){
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			count();
		}
		
	}
	public void count(){
		count++;
		//�������� ��߿� ���!
		app.lab.setText(Integer.toString(count));
	}
}