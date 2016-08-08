package com.sds.chatting;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatA extends JFrame implements ActionListener, KeyListener{
	JTextArea area;
	JTextField txt;
	JPanel p;
	JButton bt;
	JScrollPane scroll;
	ChatB ct;
	
	public ChatA(){
		area= new JTextArea();
		p=new JPanel();
		txt= new JTextField(15);
		bt= new JButton("��â");
		
		//��ũ���� �����ϰ��� �ϴ� ������Ʈ�� �μ��� �ѱ��
		scroll= new JScrollPane(area);
		
		//���Ϳ� area ����
		add(scroll);
		
		//�гο� txt�� bt������ ���ʿ� �г��� ����!
		p.add(txt);
		p.add(bt);
		add(p, BorderLayout.SOUTH);
	
		
		setBounds(100,200, 300, 400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		bt.addActionListener(this);
		txt.addKeyListener(this);
		
		
	}
	
	//��ư ������ ChatB����
	@Override
	public void actionPerformed(ActionEvent e) {
		//��ư�� ������ ��â�� ���鼭 �� �ּҰ��� ��������
		ct=new ChatB(this);
		bt.setEnabled(false);//��ư ��Ȱ��ȭ
		
	}
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
			//area�� ���������
			String msg=txt.getText();
			area.append(msg+"\n");
			//�Է¸޽��� �ʱ�ȭ
			txt.setText("");
			
			//ChatB�� area�� ���� ��������!
			ct.area.append(msg+"\n");
		}
	}

	public static void main(String[] args) {
		
		new ChatA();
	}

}
