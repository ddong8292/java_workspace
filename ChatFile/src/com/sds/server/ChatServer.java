package com.sds.server;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatServer extends JFrame implements ActionListener, Runnable {
	JPanel p_north;
	JTextField t_port;
	JButton bt_start;
	JTextArea area;
	JScrollPane scroll;
	ServerSocket server;
	Thread acceptThread;
	int port = 7777;
	boolean flag = true;
	Vector<ServerThread> list = new Vector<ServerThread>();

	public ChatServer() {
		p_north = new JPanel();
		t_port = new JTextField(Integer.toString(port), 10);
		bt_start = new JButton("가동");
		area = new JTextArea();
		scroll = new JScrollPane(area);

		p_north.add(t_port);
		p_north.add(bt_start);
		add(p_north, BorderLayout.NORTH);
		add(scroll);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
				flag = false;
			}
		});

		bt_start.addActionListener(this);
		setVisible(true);
		setBounds(500, 100, 300, 400);
	}

	public void runServer() {
		if (server != null) {
			return;
		}

		try {
			server = new ServerSocket(Integer.parseInt(t_port.getText()));
			area.append("서버 생성\n");
			
			while (flag) {
				Socket client = server.accept();
				String ip = client.getInetAddress().getHostAddress();

				area.append(ip + "님 접속\n");
				
				ServerThread st = new ServerThread(this, client);
				st.start();
				
				list.add(st);
				area.append("현재 "+list.size()+" 명 접속함\n");
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		runServer();
	}

	public void actionPerformed(ActionEvent e) {
		if(acceptThread!=null){
			return;
		}
		bt_start.setEnabled(false);
		acceptThread = new Thread(this);
		acceptThread.start();
	}

	public static void main(String[] args) {
		new ChatServer();
	}
}
