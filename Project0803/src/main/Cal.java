/*
	java.exe ����� ������ ������ �� �����͸� �Ѱܼ� �� ���� ���� ���ϴ� ���α׷�.
	
	�Ϲ������� �ڹپ��� �⺻�ڷ���(����, ����, ����)���� ����ȯ�� ��ü���� ����ȯ��
	�����ϰ� �ִ�. ������, �⺻�ڷ����� ��ü�ڷ������� ����ȯ�� �����ұ�?-�����ϳ� ��, �⺻�ڷ�������
	��ȯ�� �� �ִ� ��� ����.
	"true"-->ture(String-->boolean)
	"2"-->2(String-->int)
	Dog-->2//�Ұ�(Dog�� �⺻�ڷ������� ������ �� �ִ� ���ɼ��� ����)
	"3"-->'3'(String-->char)

	�ڹپ����� ��� �⺻�ڷ��� ���� 1:1�� �����ϴ� WrapperŬ������ ���� ��ü�ڷ����� �⺻�ڷ�������
	����ȯ�� �����ϰ� �ִ�.

	����
	byte		: Byte
	short		: Short
	int			: Integer
	long		: Long

	�Ǽ�
	float		: Float
	double	: Double

	����
	boolean	: Boolean
*/
package main;
class Cal{
	public static void main(String[] args){
		String n1=args[0];//"1"-->1
		String n2=args[1];//"2"
		
		int a = Integer.parseInt(n1);//���ڿ��� ����ȭ��Ŵ
		int b= Integer.parseInt(n2);
		System.out.println("�μ��� ����"+(a+b));
	}
}
