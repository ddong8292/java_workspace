package com.iot.main;
/*
	��Ű���� ���� Ŭ������ �������� ������ ����� 
	������ �� ����!
	�ڹ��� ���� 4�ܰ� ���(���� ������)
	public    <   protected     <   default    <     private
	
	public : ������ ó������ �ʰ� �����ϴ� ���������� ��簴ü�� ������ ������ش�.

	protected : ��Ӱ����� ��ü�� ���� ��Ű������ �ִ� ��ü���� ������ ������ش�.
	
	default : ���� ���� ��Ű������ �ִ� ��ü���Ը� ������ ���

	private : � �������Ե� ������ ������� ����.

*/
public class Bike{
	String name="kawasaki";
	public int price=2000;
	private int cc=250;
	
	public void run(){
		System.out.println(cc+"����ũ ���!");
	
	}
}
