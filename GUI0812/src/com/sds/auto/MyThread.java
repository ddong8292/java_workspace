/*
 * �ϳ��� ���μ��������� ���������� ����Ǵ� ���ν������
 * ������� �ϸ� Thread Ŭ������ �����Ѵ�
 * ����)������� �ڹ��� ������ �ƴϴ�! �����ϴ� ��κ��� �������α׷��� �����尡 �����ȴ�.
 * 			c,c#, javascript(=setTimeout() ���� ����ϰ� ����)
 * */
package com.sds.auto;

import org.w3c.dom.css.Counter;

public class MyThread extends Thread{
	int count;
	/*
	  �����ڴ� ���������� �����ϰ� ���� �ڵ尡 �ִٸ� run()�޼��带 �������ϸ� �ȴ�!
	 */
	public void run(){
		while(true){
		try {
			Thread.sleep(1000);//1�� ���� non-runnable ���·� �־��! 1�� ������ �ٽ� runnable�� ����
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		count++;
		System.out.println(count);
		}
	}
}
