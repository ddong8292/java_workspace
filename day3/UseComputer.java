class  UseComputer {
	public static void main(String[] args) {
		//컴퓨터의 메모리를 출력하고,
		Computer c=new Computer();
			c.open();
		//컴퓨터를 켜시오!
		System.out.println(c.memory);
		c.turnOn();
	}
}
