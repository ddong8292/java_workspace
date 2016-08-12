package com.sds.file;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Test extends JFrame implements ActionListener{
	JPanel pan;
	JPanel pan2;
	JLabel la;
	JLabel la2;
	JTextField txt;
	JTextField txt2;
	JButton bt1;
	JButton bt2;
	JButton bt3;
	JFileChooser chooser;
	JFileChooser chooser2;
	FileInputStream fis;
	FileOutputStream fos;
	
	public Test(){
		pan=new JPanel();
		pan2=new JPanel();
		la=new JLabel("원본경로");
		la2=new JLabel("저장경로");
		txt=new JTextField(15);
		txt2=new JTextField(15);
		bt1=new JButton("열기");
		bt2=new JButton("Save");
		bt3=new JButton("실행");
		
		pan.setLayout(new BorderLayout());
		pan.add(la, BorderLayout.WEST);
		pan.add(txt, BorderLayout.CENTER);
		pan.add(bt1, BorderLayout.EAST);
		
		pan2.setLayout(new BorderLayout());
		pan2.add(la2, BorderLayout.WEST);
		pan2.add(txt2, BorderLayout.CENTER);
		pan2.add(bt2, BorderLayout.EAST);
		
		add(pan, BorderLayout.NORTH);	
		add(pan2, BorderLayout.CENTER);
		add(bt3, BorderLayout.SOUTH);
		
		pan.setSize(500,80);
		pan2.setSize(500,80);
		
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		bt3.addActionListener(this);
		
		chooser=new JFileChooser();
		chooser2=new JFileChooser();
		
		setSize(500,200);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void Open(){
		int result=chooser.showOpenDialog(this);
		System.out.println("당신의 선택은?"+result);
		if(result==JFileChooser.APPROVE_OPTION){
			//지금 선택한 이미지를 프로필 사진에 반영
			File file=chooser.getSelectedFile();
			String path=file.getAbsolutePath();
			System.out.println(path);
			txt.setText(path);
			repaint();
		}
	}
	public void Save(){
		int result=chooser2.showOpenDialog(this);
		if(result==JFileChooser.APPROVE_OPTION){
			String path=chooser2.getSelectedFile().getAbsolutePath();
			System.out.println(path);
			txt2.setText(path);
			repaint();
		}
	}
	public void Go(){
		try{
			fis = new FileInputStream(txt.getText());
			fos = new FileOutputStream(txt2.getText());
			int data;
			while((data=fis.read())!=-1){
				fos.write(data);				
			}
		}catch(FileNotFoundException e){
			e.getStackTrace();
		}catch(IOException e){
			
		}finally{
			if(fos!=null){
				try{
					fos.close(); //스트림 닫기
				}catch(IOException e){
				}
			}
			if(fis!=null){
				try{
					fis.close(); //스트림 닫기
				}catch(IOException e){
					}
			}
			JOptionPane.showMessageDialog(this, "완료 되었습니다.");
		}
	
	}
	
	public void actionPerformed(ActionEvent e) {
		if(bt1==e.getSource()){
			Open();
		}else if(bt2==e.getSource()){
			Save();
		}else if(bt3==e.getSource()){
			Go();
		}
	}
	public static void main(String[] args) {
		new Test();
	}
}
