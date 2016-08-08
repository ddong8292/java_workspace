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

		// 스크롤을 적용하고자 하는 컴포넌트를 인수로 넘긴다
		scroll = new JScrollPane(area);

		// 센터에 area 부착
		add(scroll);

		// 패널에 txt와 bt부착후 남쪽에 패널을 부착!
		p.add(txt);
		add(p, BorderLayout.SOUTH);

		//txt와 리스너와의 연결
		txt.addKeyListener(this);
		setBounds(400, 200, 300, 400);
		setVisible(true);
		
		
		
	}
	//이 생성자도 호출하는 자는 chata의 인스턴를 넘겨야 한다
	
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
			//나와 CHatA의 area에 출력
			String msg=txt.getText();
			area.append(msg+"\n");
			cta.area.append(msg+"\n");
			txt.setText("");
			
		}
		
		
	}
		
}
