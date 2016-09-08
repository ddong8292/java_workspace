/*
 * SAX �Ľ̹���� �� �±׿�Ҹ� ��� �޸𸮿� �ø��� �����
 * �ƴ϶�, �� �±׿�Ұ� �߰ߵɶ����� �����ڿ��� �̺�Ʈ�� ����
 * �����Ѵ�..���� �޸𸮿� �ö���� ��ü�� ���� ����..
 * ���� �����ڰ� �� �̺�Ʈ Ÿ�̹��� ��ġ�� �ʰ� ������ ó��
 * �� ����� �Ѵ�..
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
		//System.out.println("������ ���ۉ�׿�?");
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



	





