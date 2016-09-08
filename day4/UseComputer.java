class UseComputer{
	public static void main(String[] args){
		Computer c  = new Computer();

		//컴퓨터의 메모리를 출력하고,
		int m=c.memory;
		System.out.println("메모리는 "+m);

		//컴퓨터를 켜시오!!
		c.turnOn();
	}
}
