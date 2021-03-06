/*
	자바언어로 네트워크 프로그램을 작성할 수 있으며, 
	java.net 패키지에서 대부분 지원한다
*/
package com.sds.network;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
	ServerSocket server;
	int port=8888; //1~1024 까지는 이미 시스템이 점유하는
	//포트이므로 사용해서는 안된다...
	//그리고, 오라클 , mysql 등 잘 알려진 소프트웨어의 포트
	//번호도 피해가야 한다...
	
	InputStreamReader reader;
	BufferedReader buffr;
	
	OutputStreamWriter writer;
	BufferedWriter buffw;
	
	public ChatServer() {
		try {
			server = new ServerSocket(port);//서버 생성!!
			System.out.println("서버 소켓 생성");
			//클라이언트의 접속을 받아들이는 메서드!!
			//참고) 이 메서드는 접속이 있을때까지 대기상태에
			//         빠진다..
			Socket client=server.accept();
			//socket에는 접속 클라이언트와 관련된 정보가 포함
			//되어 있으므로, 클라이언트의  ip 추출...
			String ip=client.getInetAddress().getHostAddress();
			System.out.println(ip+"님 접속자 발견!!");

			//데이터 받기용 스트림
			InputStream is=client.getInputStream();
			reader = new InputStreamReader(is);
			buffr = new BufferedReader(reader);
			
			//데이터 출력용 스트림
			OutputStream os=client.getOutputStream();
			writer = new OutputStreamWriter(os);
			buffw = new BufferedWriter(writer);
			
			
			String data=null;
			//데이터가 입력될때까지 지연(무한대기)에 빠진다
			while(true){
				data=buffr.readLine(); //청취
				System.out.println(data);
				
				//전송 
				buffw.write(data+"\n");
				//출력스트림 계열은, 전송시 출력스트림내에 존재
				//하는 데이터를 모두 비워야 한다!!
				buffw.flush();
			}			
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	public static void main(String[] args) {
		new ChatServer();
	}

}
