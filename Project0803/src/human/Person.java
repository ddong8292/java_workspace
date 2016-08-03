/*
	상속-한 번 작성한 클래스코드는 중복하지 않고 추후 재사용 할 수 있는데 이러한 객체지향 언에의
	개발 기법을 상속이라 한다.

	oop-은닉화, 상속
*/
package human;
public class Person{
	String color;
	public void walk(){
		System.out.println("걷습니다");
	}
	public void run(){
		System.out.println("뜁니다");
	}
}
