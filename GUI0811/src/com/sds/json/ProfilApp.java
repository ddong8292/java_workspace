package com.sds.json;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ProfilApp {
	BufferedReader buffr;
	FileReader reader;//파일을 대상으로 한 입력스트림
	String path="C:/java_workspace/GUI0811/res/member.json";
	public ProfilApp(){
		
		try {
			reader=new FileReader(path);
			buffr= new BufferedReader(reader);
			
			String data=null;
			StringBuffer sb=new StringBuffer();
			
			
			while((data=buffr.readLine())!=null){
				
				//System.out.println(data);
				sb.append(data);//sb에 누적!
			}
			
			System.out.println("sb의 값은"+sb.toString());
			//파싱시작!!
			JSONParser jsonParser=new JSONParser();
			JSONObject jsonobject=(JSONObject)jsonParser.parse(sb.toString());
			
			JSONArray jsonArray=(JSONArray)jsonobject.get("members");
			
			System.out.println(jsonArray.size());
			for(int i=0; i<jsonArray.size();i++){
				JSONObject member=(JSONObject)jsonArray.get(i);
				System.out.println(member.get("name")+","+member.get("gender")+","+member.get("age")+","+member.get("photo"));
				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
			System.out.println("Json 문법좀 공부해");
		}
		
	}
	public static void main(String[] args) {
		new ProfilApp();

	}

}
