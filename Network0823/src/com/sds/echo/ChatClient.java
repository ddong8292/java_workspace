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
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClient extends JFrame implements ActionListener{
	JTextArea area;
	JTextField field;
	JScrollPane scroll;
	JPanel pan,pan2;
	JButton bt_1;
	Socket client;//��ȭ�� ����(������=��ȭ��)
	String ip="70.12.112.110";
	int port=7777;
	BufferedReader buffr;//�Է¿� ��Ʈ��
	BufferedWriter buffw;//��¿� ��Ʈ��
	
	public ChatClient() {
		area=new JTextArea();
		field=new JTextField(15);
		pan=new JPanel();
		pan2=new JPanel();
		bt_1=new JButton("Click");
		scroll=new JScrollPane(area);
	
		
		pan2.add(field);
		pan2.add(bt_1);
		
		add(scroll, BorderLayout.CENTER);
		add(pan2, BorderLayout.SOUTH);
		
		bt_1.addActionListener(this);
		
		//�ؽ�Ʈ�ʵ�� �����ʿ���
		field.addKeyListener(new KeyAdapter() {
			
			public void keyReleased(KeyEvent e) {
				int key=e.getKeyCode();
				if(key==KeyEvent.VK_ENTER){
					//������ �޼��� ������!
					sendMsg();
				}
			}
		});
		
		setSize(300, 400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		
	}

	//������ �����ϴ� �޼��� ����
	public void connect(){
		//ip�� ��Ʈ��ȣ�� �̿��Ͽ� ������ ����!!
		try {
			client=new Socket(ip, port);//������ �߻�!!
			buffr=new BufferedReader(new InputStreamReader(client.getInputStream()));
			buffw=new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
			System.out.println("ip�� Ȯ�����ּ���.");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("��Ʈ��ũ ������ �߻��߾��!!");
		}
	}
	
	//������ �޼��� ���۸޼���
	public void sendMsg(){
		String msg=field.getText();
		try {
			//������
			buffw.write(msg+"\n");
			buffw.flush();
			
			//�ް�
			String data=buffr.readLine();
			area.append(data+"\n");
			
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
