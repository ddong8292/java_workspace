/*
 * 파일 전송시 빠른 속도로 개선해본다
 * */
package com.sds.file.progress;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class FileTransfer extends JFrame{
	String ori="C:/Users/student/Downloads/poi-bin-3.14.zip";
	String dest="C:/Users/student/Downloads/copy.zip";
	File oriFile;
	FileInputStream fis;
	FileOutputStream fos;
	
	JButton bt;
	JProgressBar bar;
	JLabel la;
	
	public FileTransfer() {
		bt = new JButton("복사실행");
		bar = new JProgressBar();
		la=new JLabel("0%");
		
		setLayout( new FlowLayout());
		
		add(bt);
		add(bar);
		add(la);
		
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				copy();
			}
		});
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(200,150);
		setVisible(true);
		
	}
	public void copy(){
		try {
			oriFile=new File(ori);
			long total=oriFile.length();
			
			System.out.println((total/1024) +"kbyte");
			fis = new FileInputStream( oriFile);
			fos = new FileOutputStream(new File(dest));
			
			int data;
			int count=0;
			//진행율 처리
			while(true){
				data=fis.read();
				if(data==-1)break;
				count++;
				la.setText( ((total/count)*100)+"%");
				la.updateUI();
				fos.write(data);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new FileTransfer();
	}

}
