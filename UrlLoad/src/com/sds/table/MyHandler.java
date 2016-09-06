package com.sds.table;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MyHandler extends DefaultHandler{
	MyModel model;
	String[] data;
	
	public MyHandler(MyModel model) {
		this.model=model;
	}
	
	//시작 태그가 발견되면 호출되는 메서드
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if(qName.equalsIgnoreCase("member")){
			System.out.println(qName);
			//일차원 배열을 만든다!
			data=new String[3];
		}
	}
	
	//태그의 값이 발견되면 호출되는 메서드
	public void characters(char[] ch, int start, int length) throws SAXException {
	
	
	}
	
	//닫는 태그의 값이 발견되면 호출되는 메서드
	public void endElement(String uri, String localName, String qName) throws SAXException {
	
	
	}
}
