/*
 *java.awt�� os�÷������� (Linux, Mac, Window..)�������� Ʋ����. ���� �̸� ������
 *API�� Swing�� ����� ����.
 *Swing�� Ư¡ : javax.swing ��Ű������ ����.
 *					 ������Ʈ�� awt ���� ���� Button-->JButton
 *			���� : awt�� ���ؼ� �ȵȴ�.
 *			 ��? : ���������ΰ� �̿ܿ��� ������ ����Ѵ�.
 *			��� : GUI���α׷��� ���߽� Swing+awt ����!
 *			
 *	�ڹ��� GUI������Ʈ�� ������ ũ�� 2������ �ִ�.
 *	1.Container(���� �����ϴ� ������Ʈ) - 
 *		JFrame(BorderLayout)
 *		JPanel(FlowLayout)
 *			-�����̳��̴�. ������ �ܵ����� ������ �� ����, �ݵ�� �����Ӿȿ� �ҼӵǾ� �ִ�. 
 *			 Ư¡ : ���� ������ �ʴ´�(div ���)
 *			 �ֿ뵵 : Frame ������ ������ ������ ���̾ƿ��� �����Ű�� ������ ���		
 *		Applet(FlowLayout)
 *	2.Visual Component(���Դ��ϴ� ������Ʈ) - 
 *		JButton
 *		JCheckbox
 *		JTextArea ���
	
 * */
package gui;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Chatwin extends JFrame{
	JTextArea tx;
	JTextField tf;
	JButton bt;
	JPanel p;
	public Chatwin(){
		super("asd");
		tx=new JTextArea();
		tf=new JTextField(15);
		bt=new JButton("����");
		p=new JPanel();//���� ����!!
		this.add(p, BorderLayout.SOUTH);
		this.add(tx, BorderLayout.CENTER);
		p.add(tf);
		p.add(bt);
		
		//������ â�� ������, ���μ����� ���̱�!
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(300, 400);
		this.setVisible(true);
	}
		public static void main(String[] args) {
			new Chatwin();
			
			
	}

}
