package com.sds.stream;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
public class test2 {
	InputStream is;
	InputStreamReader reader;
	BufferedReader bf;
	OutputStream out;
	OutputStreamWriter writer;
	BufferedWriter bfw; 
	File file;
	FileWriter fw;
	String name="C:/java_workspace/Network0823/memo.txt";
	
	public test2(){
		file=new File(name);
		try {
			fw=new FileWriter(file);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		is=System.in;
		reader= new InputStreamReader(is);
		bf=new BufferedReader(reader);
		String data=null;
		out=System.out;
		writer=new OutputStreamWriter(out);
		bfw=new BufferedWriter(fw);
	
		try {
			while(true){
				if(){
					
				}else{
					data=bf.readLine();
					System.out.println(data);
					bfw.write(data);
					bfw.newLine();
					bfw.flush();
					
					
				}
			
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		new test2();

	}

}
