package com.iot.main;

class UseString2 
{
	public static void main(String[] args){
		int x=1;
		int y=2;
		String s1=new String("apple");
		String s2 = "apple";
		String s3="apple";
		String s4=new String("apple");

		//System.out.println(x==y);
		//System.out.println(s1==s2);

		//String은 객체이므로,  s2,s3 는 레퍼런스 변수이다
		//따라서 아래의 코드는 내용비교가 아닌 주소비교이다!!
		//아래의 코드가 true 가 나오는 이유는 상수풀이라는 
		//영역에 생성되기 때문이다. 
		//상수풀의 특징  - 중복된 상수가 있다면, 재생성하지
		//                      않는다.
		System.out.println(s2==s3); 
		
		System.out.println(s1==s4);
		
		String s=""; //고정된 데이터 일단 생성된 후 변경불가
		//immutable : 불변

		for(int i=0;i<10;i++){
			s=s+i; //s0,s1,s2....
		}
		
		//스트링객체의 불변(=편집불가)의 특징으로 인하여, 자바의 String에는
		//누적이라는 개념은 존재하지 않는다...
		String k="korea";

		for(int i=0;i <10;i++){
			k=k+" fighting";
		}
		System.out.println(k);

		//해결책??  편집 가능한 객체를 이용하는것...
		//주의) String 클래스 아님!!
		StringBuffer b = new StringBuffer();
		b.append("korea");
		b.append("fighting"); //새롭게 X, 기존 b가 변경
		
		//String 이 아니기 때문에 toString()메서드로 변환시킨후
		//출력하자!!
		System.out.println(b.toString());
	}
}
