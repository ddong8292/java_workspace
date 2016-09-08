/*
1.Cat이라는 이름의 고양이클래스를 정의하되, 
    이름, 나이, (종과-고양이과)를 멤버로 보유하시오..

2.특히 종류의 경우엔 static 으로 선언하시오!~

3.현재 클래스에 main 실행부를 두되, 
   고양이의 이름,나이,종류를 출력하시오.
*/
class Cat {
	String name="나비";
	int age=3;
	static String type="고양이과";

	public static void main(String[] args){
		//System.out.println(name);
		int x=3;
		Cat c1 = new Cat();
		Cat c2 = new Cat();
		Cat.type="파충류"; //Cat이라는 클래스가 보유한 변수
	}
}
