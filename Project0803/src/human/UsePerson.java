package human;
class UsePerson{

	public static void main(String[] args){
		//������ �Ǻλ��� ����Ͻÿ�
		WhitePerson w=new WhitePerson();
			System.out.println(w.color);
			w.openParty();
			w.walk();
		BlackPerson b=new  BlackPerson();
			System.out.println(b.color);
			b.rap();
			b.walk();
		YellowPerson y=new YellowPerson();
			System.out.println(y.color);
			y.chopstick();
			y.walk();
	}
}
