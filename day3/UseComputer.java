class  UseComputer {
	public static void main(String[] args) {
		//��ǻ���� �޸𸮸� ����ϰ�,
		Computer c=new Computer();
			c.open();
		//��ǻ�͸� �ѽÿ�!
		System.out.println(c.memory);
		c.turnOn();
	}
}
