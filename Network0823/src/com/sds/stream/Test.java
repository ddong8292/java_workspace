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
public class Test {
	InputStream is;
	InputStreamReader reader;
	BufferedReader bf;
	OutputStream out;
	BufferedWriter bfw; 
	File file;
	FileWriter fw;
	String name="C:/java_workspace/Network0823/memo.txt";
	
	public Test(){
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
		bfw=new BufferedWriter(fw);

		try {
			while(true){
				data=bf.readLine();
				System.out.println(data);
				bfw.write(data);
				bfw.newLine();
				fw.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		new Test();

	}

}