/*
	�ڹٵ� �ٸ� �������α׷�ó��, GUI�� �����Ѵ�.
	��) ������, ��ư, üũ�ڽ�, TextArea ����� ����.
	�ڹٿ��� GUI������Ʈ�� awt��Ű������ �����Ѵ�
*/
package gui;
import java.awt.Frame;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Checkbox;
import java.awt.TextField;
import java.awt.TextArea;
import java.awt.Choice;
class GuiTest{
	
	public static void main(String[] args){
		//��� GUI ������Ʈ�� �÷��� ������ â
		//�ڹٿ��� �������� ����Ʈ�Ӽ��� �����ϴµ� �⺻�� ������ �ʴ� �Ӽ��� ������ �ִ�. ���� ���̰� ����!
		Frame win=new Frame();
		win.setVisible(true);//���̰� �ϱ�
		win.setSize(700,700);
		win.setTitle("�� ������");
		
		Button bt=new Button("click");		
		
		//�ڹپ� htmló�� �� ��ǻ��Ʈ�� �����ϱ⿡ �ռ� ��� ��� �������� ���� ������ ����� �����ȴ�! 
		//�� ���������� �����ϰ� ���ڴ�
		FlowLayout flow=new FlowLayout();
		win.setLayout(flow);//��ġ ����� �����ϴ� �޼���
		//��ư�� �����ӿ� ����!
		win.add(bt);
		
		//�ڹٿ����� ��ü���� �ڷ����̴�. ���� �迭�� �󸶵��� �����ϴ� String[] args
		Checkbox[] ch=new Checkbox[20];
			for(int i=0;i<20;i++){
			Checkbox c = new Checkbox(i+"��° �ڽ�");
			ch[i]=c;
			win.add(ch[i]);
			}
		TextField tf=new TextField(20);
			win.add(tf);
		TextArea ta=new TextArea(10,10);//rows-����, columns-����
			win.add(ta);
		Choice co=new Choice();
			for(int i=1; i<=12; i++){
				co.add(Integer.toString(i));
			}
			win.add(co);
	}
}
