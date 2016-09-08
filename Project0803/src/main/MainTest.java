/*
main() 메서드의 인수인 args를 사용해본다
왜?? 머리식힐려고...
main 개발자가 원할때 마음대로 호출할 수 있는
메서드가 아니라, 어플리케이션이 시작될때
최초 한번 호출되는메서드이다..
java.exe  파일에 의해 자동호출...

바나나 딸기 수박
String[] arr = new String[3];
arr[0]="바나나";
arr[1]="딸기";
arr[2]="수박";
*/
package main;
class  MainTest{
	public static void main(String[] args){
		System.out.println("프로그램 실행시 넘겨받은 인수의 갯수는 "+args.length);
		
		for(int i=0; i<args.length;i++){
			System.out.println(args[i]);
		}
	}
}
