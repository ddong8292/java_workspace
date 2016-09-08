class Dog{
	int b=3;
	{
		for(int i=1;){
		
		}
	}

	String name="뽀미";
	/*인스턴스 초기화 블럭!!
		- 이 클래스로부터 생성되는 인스턴스가 있을때마다
		  이 영역이 수행됨!!
	*/

	/*클래스가 최초에 로드되어질때 수행!!*/
	static{
		System.out.println("static 초기화 블럭수행!");
	}
	
	/*클래스로부터 인스턴스가 생성될때마다 수행*/
	{
		System.out.println("인스턴스 초기화 블럭수행!");
	}

	public static void main(String[] args){
		Dog k =new Dog();
		for(int i=1;i<=3;i++){
			new Dog();
		}
		//이름이 없으면, 이후 라인에서 제어 불가능!!
		
		Dog d=new Dog();
	}

}
