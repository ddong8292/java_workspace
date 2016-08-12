package com.sds.json;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class jsonProflie extends JFrame{
	JPanel p_west;
	JButton bt;
	JScrollPane scroll;
	JPanel p_center;
	JFileChooser chooser;
	FileReader reader;
	BufferedReader buffr;
	StringBuffer sb;
	public jsonProflie(){
		p_west=new JPanel();
		bt=new JButton("열기");
		p_center=new JPanel();
		scroll=new JScrollPane(p_center);
		chooser=new JFileChooser("C:/java_workspace/GUI0812/res");
		//왼쪽 패널에 버튼 부착 후 패널을 서쪽에 부착
		
		p_west.add(bt);
		add(p_west, BorderLayout.WEST);
		p_west.setBackground(Color.PINK);
		
		//센터에 스크롤 부착!
		add(scroll);
		p_center.setBackground(Color.YELLOW);

		
		//이거 안해주면 우측으로 한없이 붙는다!
		p_center.setPreferredSize(new Dimension(700, 600));
		
		//버튼에 이벤트 구현
		bt.addActionListener(new ActionListener() {		
			public void actionPerformed(ActionEvent e) {
				openFile();
				
			}

	
		});
		
		setSize(800,600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	//데이터수에 따라 profile 인스턴스 생성메서드정의
	public void createProflie(){
		
		//파싱 시작~!!
		JSONParser jsonparser=new JSONParser();
		try {
			JSONObject jsonobject=(JSONObject)jsonparser.parse(sb.toString());
			JSONArray jsonarray=(JSONArray)jsonobject.get("members");
			for(int i=0; i<jsonarray.size(); i++){
				JSONObject member=(JSONObject)jsonarray.get(i);
				
				String name=(String)member.get("name");
				String gender=(String)member.get("gender");
				Long age=(Long)member.get("age");
				String photo=(String)member.get("photo");
				
				
				Profile profile=new Profile(photo);
				profile.la_name.setText("이름"+name);
				profile.la_gender.setText("성별"+gender);
				profile.la_age.setText("나이"+age);
				
				p_center.add(profile);
				
			}
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			p_center.updateUI();
	
	}
	private void openFile() {
		if(chooser.showOpenDialog(this)==JFileChooser.APPROVE_OPTION){
			//제이슨 열기
			File file=chooser.getSelectedFile();//유저가 선택한 파일!
			try {
				reader=new FileReader(file);
				buffr=new BufferedReader(reader);
				
				sb=new StringBuffer();
				String data=null;
				while((data=buffr.readLine())!=null){
					sb.append(data);
				}
				System.out.println(sb.toString());
				
				createProflie();
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				if(buffr!=null)
					try {
						buffr.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		
		}
		
	}
	
	public static void main(String[] args) {
		new jsonProflie();

		
		
	}
}
