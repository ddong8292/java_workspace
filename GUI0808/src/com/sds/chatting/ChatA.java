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
		bt= new JButton("새창");
		
		//스크롤을 적용하고자 하는 컴포넌트를 인수로 넘긴다
		scroll= new JScrollPane(area);
		
		//센터에 area 부착
		add(scroll);
		
		//패널에 txt와 bt부착후 남쪽에 패널을 부착!
		p.add(txt);
		p.add(bt);
		add(p, BorderLayout.SOUTH);
	
		
		setBounds(100,200, 300, 400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		bt.addActionListener(this);
		txt.addKeyListener(this);
		
		
	}
	
	//버튼 누르면 ChatB띄우기
	@Override
	public void actionPerformed(ActionEvent e) {
		//버튼을 누르면 새창을 띄우면서 그 주소값도 보유하자
		ct=new ChatB(this);
		bt.setEnabled(false);//버튼 비활성화
		
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
			//area에 데이터출력
			String msg=txt.getText();
			area.append(msg+"\n");
			//입력메시지 초기화
			txt.setText("");
			
			//ChatB의 area에 값을 누적하자!
			ct.area.append(msg+"\n");
		}
	}

	public static void main(String[] args) {
		
		new ChatA();
	}

}
