package com.sds.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ServerThread extends Thread{
	ChatServer chatServer;
	Socket client;
	BufferedReader buffr;
	BufferedWriter buffw;
	boolean flag=true;
	
	InputStream is;
	FileOutputStream fos;
	
	public ServerThread(ChatServer chatServer, Socket client){
		this.chatServer=chatServer;
		this.client=client;
		
		try {
			buffr = new BufferedReader(new InputStreamReader(client.getInputStream()));
			buffw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void run() {
		while(flag){
			listen();
		}
	}
	public void listen(){
		String msg=null;
		try {
			msg=buffr.readLine();
			//"requestType=message&data="+msg
			
			String[] params=msg.split("&");
			String[] param1=params[0].split("=");
			
			System.out.println(param1[0]+","+param1[1]);
			String requestType=param1[1];
			
			if(requestType.equals("message")){ //대화라면..
				msg=(params[1].split("="))[1];
				chatServer.area.append(msg+"\n");
				send(msg);
			}else if(requestType.equals("file")){ //파일전송이라면, 스트림을 쓰레드로 처리한다.
				Thread thread = new Thread(){
					public void run() {
						try {
							is=client.getInputStream();
							fos = new FileOutputStream("C:/product_img/wild.wmv");
							byte[] b = new byte[1024];
							
							int data;
							while((is.read(b))!=-1){
								//fos.write(b);
								//fos.flush();
							}
							send("전송이 완료되었습니다.");
						} catch (IOException e) {
							e.printStackTrace();
						}finally{
							if(fos!=null){
								try {
									fos.close();
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
							if(is!=null){
								try {
									is.close();
								} catch (IOException e) {
									e.printStackTrace();
								}
							}
						}
					}
				};
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void send(String msg){
		
		try {
			buffw.write(msg+"\n");
			buffw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
