package com.sds.chatting;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatB extends JFrame implements KeyListener{
	JTextArea area;
	JTextField txt;
	JPanel p;
	JScrollPane scroll;
	ChatA cta;
	
	public ChatB(ChatA cta) {
		this.cta=cta;
		area = new JTextArea();
		p = new JPanel();
		txt = new JTextField(15);

		// ��ũ���� �����ϰ��� �ϴ� ������Ʈ�� �μ��� �ѱ��
		scroll = new JScrollPane(area);

		// ���Ϳ� area ����
		add(scroll);

		// �гο� txt�� bt������ ���ʿ� �г��� ����!
		p.add(txt);
		add(p, BorderLayout.SOUTH);

		//txt�� �����ʿ��� ����
		txt.addKeyListener(this);
		setBounds(400, 200, 300, 400);
		setVisible(true);
		
		
		
	}
	//�� �����ڵ� ȣ���ϴ� �ڴ� chata�� �ν��ϸ� �Ѱܾ� �Ѵ�
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_ENTER){
			//���� CHatA�� area�� ���
			String msg=txt.getText();
			area.append(msg+"\n");
			cta.area.append(msg+"\n");
			txt.setText("");
			
		}
		
		
	}
		
}
