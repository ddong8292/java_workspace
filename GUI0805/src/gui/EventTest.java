package gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

/*
 * �ڹٿ����� ���콺 ������ �̺�Ʈ�� click�̶�� �θ��� �ʴ´�!. ActionEvent�� �Ѵ�.
GUI ������Ʈ�󿡼� Ŭ���̺�Ʈ�� �߻��ϸ�, ���� os�� �����Ͽ� �˸´� ������ JVM�� �ѱ��
�������� JVM�� �ش� �̺�Ʈ�� �˸´� Event��ü�� �޸𸮿� �ø���!
	ex) ���콺 Ŭ�� -->window ���� -->jvm ����
		-->ActionEvent ��ü �ν��Ͻ� ����--> �����ʿ� ����
*/
public class EventTest extends JFrame implements ActionListener{
	JButton bt;
	JButton bt2;
	
	public EventTest(){
		bt=new JButton("���ʹ�ư");
		bt2=new JButton("�����ʹ�ư");
		
		//���� ���� ���̾ƿ� ����!
		this.setLayout(new FlowLayout());
		
		this.add(bt);
		this.add(bt2);
		
		this.setSize(300, 400);
		this.setVisible(true);
		
		//��ư�� �����ʿ��� ����!
		bt.addActionListener(this);
		bt2.addActionListener(this);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	//jdk 5���� �����ϴ� ������̼��̶�� �ּ�!
	//�Ϲ��ּ��� Ʋ����? - ���α׷� ����� ���� �� �ִ� �ּ�
	@Override
	//�Ʒ��� �޼���� ����ڰ� ActionEvent�� ����ų ������ ȣ��ȴ�! �׸��� �Ű������� �ش� Action
	//Event�ν��Ͻ��� ���޵ȴ�
	//�̺�Ʈ�� ����Ų ��ü ������Ʈ�� �ڹٿ����� �̺�Ʈ�ҽ��� �Ѵ�. ���� ����, action �̺�Ʈ�� ����Ų
	//��ü�� ��ư�̹Ƿ�, ��ư�� �̺�Ʈ �ҽ��� �ȴ�.
	public void actionPerformed(ActionEvent e) {
		
		//Action�̺�Ʈ�� �ݵ�� ��ư���� ������ �� �ִ� �̺�Ʈ�� �ƴ϶� �ٸ� ������Ʈ�� ActionEvent�� ����ų�� �ִ�.
		//���� sun������ ���� �߻��� �̺�Ʈ�� ��ư�� ���� ������ �ٸ� ������Ʈ�� ���� ������ �����Ҽ� �����Ƿ� 
		//���� ������ Object������ �޾ƹ�����.
		Object obj=e.getSource();
		//JButton btn=(JButton)obj;
		
		
		if(obj==bt){
		System.out.println("����");
		}else if(obj==bt2){
		System.out.println("����");
		}
		
	}
	
	
	public static void main(String[] args) {
		new EventTest();
		
	}

}
