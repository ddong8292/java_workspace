/*
	������ �ڵ����� ����� ����� ������
*/
package com.iot.main;
/*
	Ŭ������ ������ ������ ��ü�ڷ����� ��� 
	Car has a Wheel : has a ����
*/
public class Car{

	private Wheel w; //�� ��
	private Engine e;
	private Handle h;
	private int price;

	//�����ڸ� �����Ͽ� �ʱ�ȭ �۾��� ������ ����!
	public Car(){
		w=new Wheel();
		e=new Engine();
		h=new Handle();
		price=200;
	}
	public void go(){
		w.roll();
		e.bound();
		h.control();
	}
}
