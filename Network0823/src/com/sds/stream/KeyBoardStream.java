/*
 * 1.Stream �̶�? �������� �帧
 * 
 * 2.�з�
 * 		(1)���⼺(�������� ���α׷��� ����=���μ���)
 * 			-�Է�(Input)
 * 			-���(Output)
 * 		
 * 		(2)������ ó�� ���
 * 			-����Ʈ��� ��Ʈ��
 * 			 �⺻ ��Ʈ���̸� 1byte�� ����
 * 
 *  		-���ڱ�� ��Ʈ��
 *  		 2byte�� �����ϴ� ��Ʈ�� 
 *  		 �񿵾�� ����(2byte�� ó��)�� ǥ���� �� �ִ�
 *  		
 *  		-���۱�� ��Ʈ��
 *  		 ������ ������ ���� �߰��Ҷ���, ���ۿ� ��Ƶ� 
 *  		 �����͸� �о���̵��� ó���� ��Ʈ��
 * */
package com.sds.stream;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class KeyBoardStream {
	InputStream is;
	InputStreamReader reader;
	BufferedReader bf;
	int count;
	
	public KeyBoardStream() {
		//Keyboard, ���ڵ彺ĳ�� �� �ý����� �����ϴ� ��Ʈ���� �����ڰ� ���ϴ� ������ ������� ������ �� ����!
		//���� �ý������κ��� ���;� �Ѵ�!!
		is=System.in;
		reader= new InputStreamReader(is);
		bf=new BufferedReader(reader);
		String data=null;
		
		try {
			while(true){
				data=bf.readLine();
				System.out.println(data);
				count++;
				System.out.print("������ Ƚ��"+count);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		new KeyBoardStream();

	}

}
