package animal;
class UseBird{
	public static void main(String[] args){
		Sparrow d=new Sparrow();
		//������ ����� ���������� �ڹٿ����� ������ü�� ������ü�� ����Ű�� ���� �����ϴ�.
		//Bird bird = new Sparrow();
		//bird.wing();
		Bird b= new Sparrow();
		System.out.println(b.name);

		b.wing();
	}
}
