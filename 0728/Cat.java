/*
1.cat�̶�� �̸��� ������� Ŭ������ �����ϵ�,
	�̸�, ����, ������ ����� �����Ͻÿ�.
2.Ư�� ������ ��쿣 static���� �����Ͻÿ�~
3.���� Ŭ������ main ����θ� �ε�,
	������� �̸�, ���� ,������ ����Ͻÿ�.
*/
class Cat{
	String name="cat";
	int age=3;
	static String type="����̰�";
	
	public static void main(String[] args) {
		Cat c=new Cat();
		System.out.println(c.name);
		System.out.println(c.age);
		System.out.println(c.type);
		
	}
}