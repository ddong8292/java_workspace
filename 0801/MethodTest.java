/*
클래스를 구성하는 요소는 단 2가지 밖에 없다!!
오늘은 메서드에 대해 학습한다!!
*/
class MethodTest{
	/* 자바의 메서드의 표기법은 총 3단계로 구성
		맨앞 : 접근 제한자
		가운데 : 반환여부를 표기
		            반환값이 없는 메서드의 경우엔 반드시
                     void 를 표기한다!
		맨끝 : 메서드명
	*/
	public void sum(){
		int x;
	}		

	//반환값 있는 메서드 정의 
	public int sum2(){
		return 3;
	}

	public char sum3(){
		return 'A';
	}

	public boolean sum4(){
		return true;
	}

	//자바도 다른 언어와 마찬가지로 매개변수를 지원한다!
	public void sum5(boolean a){
	
	}
}
