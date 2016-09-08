package com.sds.echo;

import java.awt.BorderLayout;
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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClient extends JFrame implements ActionListener{
	JPanel p_south;
	JTextArea ta_msg;
	JScrollPane scroll;
	JTextField tf_insert;
	JButton bt_con;
	Socket client; //대화용 소켓!!(종이컵=전화기)
	String ip="70.12.112.90";
	int port=8888;
	BufferedReader buffr; //입력용 스트림
	BufferedWriter buffw; //출력용 스트림
	
	public ChatClient() {
		p_south = new JPanel();
		ta_msg = new JTextArea();
		scroll = new JScrollPane(ta_msg);
		tf_insert = new JTextField(15);
		bt_con = new JButton("접속");
		
		p_south.add(tf_insert);
		p_south.add(bt_con);
		
		add(scroll);
		add(p_south, BorderLayout.SOUTH);
		
		//버튼과 리스너 연결
		bt_con.addActionListener(this);
		
		//텍스트필드와 리스너연결 
		tf_insert.addKeyListener(new KeyAdapter(){
			public void keyReleased(KeyEvent e) {
				int key=e.getKeyCode();
				
				if(key==KeyEvent.VK_ENTER){
					//서버에 메세지 보내기!
					sendMsg();
				}
			}
		});
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300,400);
		setVisible(true);
	}
	
	//서버에 접속하는 메서드 정의
	public void connect(){
		//ip와 포트번호를 이용하여 서버에 접속!!!
		try {
			client= new Socket(ip, port);// 접속이 발생!!
			buffr = new BufferedReader(new InputStreamReader(client.getInputStream())); 
			buffw=new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
			System.out.println("ip를 확인해주세요...");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("네트워크 문제가 발생했어요!!");
		}
	}
	
	//서버에 메세지 전송메서드 
	public void sendMsg(){
		String msg=tf_insert.getText();
		
		try {
			//보내고
			buffw.write(msg+"\n");
			buffw.flush();
			
			//받고 
			String data=buffr.readLine();
			ta_msg.append(data+"\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		connect();
	}
	
	public static void main(String[] args) {
		new ChatClient();
	}

}




