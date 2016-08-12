package com.sds.json;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
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

public class Test extends JFrame implements ActionListener{
	JPanel pan;
	JPanel pan2;
	JButton bt;
	JScrollPane scroll;
	JFileChooser chooser;
	BufferedReader buffr;
	FileReader reader;
	String path;
	public Test(){
		pan=new JPanel();
		bt=new JButton("열기");
		pan2=new JPanel(new GridLayout(0, 1));
		scroll=new JScrollPane(pan2);
		chooser= new JFileChooser();
		
		
		
		pan.add(bt, BorderLayout.NORTH);
		add(pan, BorderLayout.WEST);
		add(scroll);
		
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		bt.addActionListener(this);
	}
	public void open(){
		int result=chooser.showOpenDialog(this);
		if(result==JFileChooser.APPROVE_OPTION){
			File file=chooser.getSelectedFile();
			path=file.getAbsolutePath();
			
			try {
				reader= new FileReader(file);
				buffr=new BufferedReader(reader);
				
				StringBuffer sb=new StringBuffer();
				
				String data=null;
				while((data=buffr.readLine())!=null){
					//pan2.add(this, data+"\n");
					sb.append(data);
					
				}
				System.out.println("sb의 값은"+sb.toString());
				JSONParser jsonParser=new JSONParser();
				JSONObject jsonobject=(JSONObject)jsonParser.parse(sb.toString());
				JSONArray jsonArray=(JSONArray)jsonobject.get("members");
				
				System.out.println(jsonArray.size());
				for(int i=0; i<jsonArray.size();i++){
					JSONObject member=(JSONObject)jsonArray.get(i);
					String name = (String)member.get("name");
					String gender = (String)member.get("gender");
					String age = (String)member.get("age");
					String url = (String)member.get("photo");
					//System.out.println(member.get("name")+","+member.get("gender")+","+member.get("age")+","+member.get("photo"));
					pan2.add(new Text2(name, gender, age, url));
				}
				pan2.updateUI();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				e.printStackTrace();
			}

		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		open();
		
	}
	public static void main(String[] args) {
		new Test();
	}

}
