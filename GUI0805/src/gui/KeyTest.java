/*
 * 	�ڹ� ����� ���ø����̼��� �̺�Ʈ ��������!
	1�ܰ� - �˸´� �����ʸ� �����ϱ�!
	2�ܰ� - �������� �޼��� �������ϱ�!(�ҿ����� �޼��� �ϼ�)
	3�ܰ� - �̺�Ʈ �ҽ�(�̺�Ʈ ����Ų ������Ʈ)�� 
				�����ʿ��� ����!
	
 * */
package gui;

import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class KeyTest extends JFrame implements KeyListener{
	JTextField tf;
	JButton bt;
	
	
	public KeyTest(){
		tf=new JTextField(10);
		bt=new JButton("Ŭ��");
		
		this.setLayout(new FlowLayout());
		this.add(tf);
		this.add(bt);
		
		this.setSize(300,400);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		//���� Ŭ������ ����������, �� key�������̹Ƿ�..
		tf.addKeyListener(this);
		
	}
	

	@Override
	public void keyTyped(KeyEvent e) {
		
	}


	@Override
	public void keyPressed(KeyEvent e) {
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("������ ������?");
		
	}
	public static void main(String[] args) {
		new KeyTest();
		
	}
}
