/*
	�޸����� �����θ� ��������.. ù���̴ϱ�.
*/
package gui;
import java.awt.Frame;
import java.awt.MenuBar;
import java.awt.Menu;
import java.awt.TextArea;
import java.awt.MenuItem;
class Memo{
	public static void main(String[] args){
		//�޸��� ������ ����
		Frame frame=new Frame();
		
		//�޴��� ����
		MenuBar bar= new MenuBar();
		
		//�޴���
		String[] menuTitle={"����","����","����","����","����"};
		Menu[] m=new Menu[5];
		for(int i=0;i<m.length;i++){
			m[i]=new Menu(menuTitle[i]);
			bar.add(m[i]);//�޴��ٿ� ����
		}
		//�����쿡 �޴��� ����!
		frame.setMenuBar(bar);

		//�޴������۵�
		String[] item={"����" , "����", "�ٸ��̸����� ����", "apple", "������"};
		MenuItem[] mi=new MenuItem[5];
		for(int i=0; i<mi.length; i++){
			mi[i]=new MenuItem(item[i]);
			m[0].add(mi[i]);
		}
		
		//TextArea ����!
		TextArea area= new TextArea(30,40);
		frame.add(area);

		//������ ũ��, ���̰� �ϱ�
		frame.setSize(600,500);
		frame.setVisible(true);

	}
}
