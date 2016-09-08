/*
 * SAX 파싱방식은 각 태그요소를 모두 메모리에 올리는 방식이
 * 아니라, 각 태그요소가 발견될때마다 개발자에게 이벤트를 통해
 * 전달한다..따라서 메모리에 올라오는 객체는 따로 없다..
 * 따라서 개발자가 이 이벤트 타이밍을 놓치지 않고 적절한 처리
 * 를 해줘야 한다..
 * */
package com.sds.xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MyHandler2 extends DefaultHandler{
	
	boolean name;
	boolean age;
	boolean gender;
	
	public void startDocument() throws SAXException {
		//System.out.println("문서가 시작됬네요?");
	}
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		System.out.println("<"+qName+">");
		
		if(qName.equals("name")){
			name=true;
		}else if(qName.equals("age")){
			age=true;
		}else if(qName.equals("gender")){
			gender=true;
		}	
	}
	
	public void characters(char[] ch, int start, int length) throws SAXException {
		String data=null;
		
		if(name){
			data = new String(ch,start, length);
			name=false;
			System.out.println(data);
		}else if(age){
			data = new String(ch,start, length);
			age=false;
			System.out.println(data);
		}else if(gender){
			data = new String(ch,start, length);
			gender=false;
			System.out.println(data);
		}	
		
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		System.out.println("</"+qName+">");
		
	}
	

}



	





