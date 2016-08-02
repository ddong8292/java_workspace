/*
	고객 계좌를 정의한다
	클래스 작성시 변수는 private로 접근을 제한하고 이 변수에 대한 조작은 메서드를 통해 제공하는 객체
	지향언어의 개발 기법을 가리켜 은닉화(=encapsulation)라 한다.
*/
package com.iot.main;
public class Account{
	//실질적으로 클래스가 보유한 데이터는 보호대상이다. 따라서 private으로 보안처리.
	private String num="110-58789-232";
	private int total=3000;

	//고객의 계좌를 접근할수 있는 메서드를 제공.
	public int getTotal(){
		return total;
	}

	//멤버변수의 값을 변경할 용도로 정의되는 메서드를 가르켜 setter라 한다! setter메서드 정의시 규칙
	//set+멤버변수명, 주의 set뒤에 오는 단어는 첫 철자를 대문자로 한다.
	public void setTotal(int total){
		this.total=total;
	}

}
