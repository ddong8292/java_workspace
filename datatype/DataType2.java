/*
금기사항
1.클래스명은 숫자로 시작하지 말것
2.클래스명은 소문자로 시작하지 말것 
3.클래스명은 특수문자를 사용하지 말것
   단, 언더바(__)는 가능은 하나 비추..
*/
class DataType2{
	public static void main(String[] args){
		byte b=3;
		int a=5;

		//강제 형변환!!  
		//(소괄호)는 형변환 연산자!!
		b=(byte)a;
		
		short s=7;
		int k=6;

		k=s; //자동형변환(손실이 없기때문에 묻지X)
	}
}