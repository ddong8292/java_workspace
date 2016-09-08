/*문자 자료형에 대한 학습
	scjp(sun certified java programmer)
	ocjp(oracle certified java programmer)
	1+1

	문자
	숫자  -	정수 : 소수점 표현 불가..
	            byte < short < int < long
					1        2        4        8
				실수 : 소수점까지 표현가능한 수
				float < double
				4             8
	논리값
*/
class CharTest{
	public static void main(String[] args){
		//문자 자료형이란 사실상 존재하지 않는다..
		//왜?? 어차피 문자는 곧 숫자로 바뀌니깐...
		//단, 이 숫자의 목적은 연산 수행이 아닌 키코드값과 매핑
		//목적으로 사용해야 한다..
		char x='a';
		char y=3; //가장 좋아함!!
		char k=9;
		char z=-1;//키코드 매핑이 목적이므로, 음수는 지원하지
		//않는다!!!

		System.out.println(y+k);
	}
}