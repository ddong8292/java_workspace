package com.iot.animal;

public class Dog{
	private String name="말티즈";
	int age;
	String gender="여자";

	/**
		객체 인스턴스 생성시 이 메서드는 무조건 호출되므로 초기화 목적으로 사용하자!
	*/
	public Dog(int age, String gender){
		this.age=age;
		this.gender=gender;
	}
	public void bark(){
		System.out.println("멍멍");
	}
}
