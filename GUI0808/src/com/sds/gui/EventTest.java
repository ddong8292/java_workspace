/*
 * �Ʒ��� ��Ģ�� �� �������!(=�ȵ���̵� ���߽� ����)
 * 1.�˸´� ������ ����
 * 2.�������� �޼��� ������
 * 3.�̺�Ʈ �ҽ�(=�̺�Ʈ�� ����Ų ������Ʈ)�� �����ʿ��� ����
 * */
package com.sds.gui;

import java.awt.Event;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class EventTest extends JFrame implements ActionListener, KeyListener, WindowListener{
	JTextField txt;
	JButton bt;
	
	public EventTest(){
		txt=new JTextField(15);
		bt=new JButton("Button");
		
		
		setLayout(new FlowLayout());
		add(txt);
		add(bt);
		
		//��ư�� �����ʿ��� ����
		bt.addActionListener(this);
		//�ؽ�Ʈ�ʵ�� ������ ����
		txt.addKeyListener(this);
		//������� �����ʿ��� ����
		this.addWindowListener(this);
		
		setVisible(true);
		setSize(300, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("������?");
		
	}
	//Ű�����ʰ� ������ �޼��� �������̵�!!

	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		
		int key=e.getKeyCode();
		
		if(key==KeyEvent.VK_ENTER){
			System.out.println("�����ƾ�?");
			
		}
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("windowOpened ȣ��");
	}
	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("windowClosing ȣ��");
		
	}
	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("windowClosed ȣ��");
		
	}
	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("windowIconified ȣ��");
	}
	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("windowDeiconified ȣ��");
	}
	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("windowActivated ȣ��");
	}
	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("windowDeactivated ȣ��");
	}
	public static void main(String[] args) {
		new EventTest();
	}
}