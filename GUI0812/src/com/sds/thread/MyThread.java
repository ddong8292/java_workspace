package com.sds.thread;

import com.sds.auto.CounterApp;

public class MyThread extends Thread{
	/*
	  �����ڴ� ���������� �����ϰ� ���� �ڵ带  run�޼��忡 �ۼ��ؾ� �Ѵ�.
	 */
	int count=0;
	CounterApp app;//null
	
	public void run(){
		
		
	}
	public void count(){
		count++;
		//�������� ��߿� ���!
		app.lab.setText(Integer.toString(count));
	}
}
