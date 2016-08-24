package com.sds.echo2;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClient extends JFrame implements ActionListener{
	JPanel p_north;
	Choice ch_ip;
	JButton bt;
	JTextArea area;
	JScrollPane scroll;
	JTextField t_input,t_port;
	Socket client;//대화용 소켓!!
	ClientThread ct;
	
	public ChatClient() {
		p_north=new JPanel();
		ch_ip=new Choice();
		bt= new JButton("접속");
		area=new JTextArea();
		scroll=new JScrollPane(area);
		t_input=new JTextField();
		t_port=new JTextField("7777",4);
		
		for(int i=90; i<=121; i++){
			ch_ip.add("70.12.112."+i);
		}
		p_north.add(ch_ip);
		p_north.add(t_port);
		p_north.add(bt);
		
		add(p_north, BorderLayout.NORTH);
		add(scroll);
		add(t_input, BorderLayout.SOUTH);
		
		//버튼과 리스너 연결
		bt.addActionListener(this);
		
		//텍스트필드와 리스너 연결
		t_input.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
					ct.sendMsg(t_input.getText());
					t_input.setText("");//입력내용 지우기!
				}
			}
		});
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(300,100,300,400);
		setVisible(true);
	}
	//에코 서버에 접속
	public void connect(){
		String ip=ch_ip.getSelectedItem();
		String port=t_port.getText();
		try {
			client=new Socket(ip, Integer.parseInt(port));
			ct=new ClientThread(this);
			ct.start();//대화용 쓰레드 동작 시작!!

		} catch (NumberFormatException e) {
			showMsg("포트번호는 정수로 입력해야 합니다");
			e.printStackTrace();
		} catch (UnknownHostException e) {
			showMsg("올바르지 않은 주소 입니다");
		} catch (IOException e) {
			showMsg("소켓 연결 실패..");
			e.printStackTrace();
		}
		
		
	}
	//서버에 메세지 전송하기!!
	
	//서버로부터 메세지 청취하기!!
	
	public void showMsg(String message){
		JOptionPane.showMessageDialog(this, message);
		
	}
	public void actionPerformed(ActionEvent e) {
		connect();
		bt.setEnabled(false);
	}
	public static void main(String[] args) {
		new ChatClient();
	}

}
