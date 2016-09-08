package music;
class UseMusic{
	public static void main(String[] args){
		//실습: 추상클래스는 메모리에 올릴 수 있는가?
		//결론: 인스턴스화 될수 없다!!
		//해결책: 상속관계에서 자식의 인스턴스가 생성되기
		//           직전에 부모의 인스턴스가 메모리 먼저 올라가는
		//            현상을 이용한다
		//            즉, 자식에 의해서만 올릴 수 있다..
		//            자식이 구현을 완료한 후 인스턴스화될때 
		//            같이 올라간다!!
		MusicDevice md = new MusicDevice();
	}
}
