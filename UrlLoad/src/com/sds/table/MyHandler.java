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
	
	//���� �±װ� �߰ߵǸ� ȣ��Ǵ� �޼���
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if(qName.equalsIgnoreCase("member")){
			System.out.println(qName);
			//������ �迭�� �����!
			data=new String[3];
		}
	}
	
	//�±��� ���� �߰ߵǸ� ȣ��Ǵ� �޼���
	public void characters(char[] ch, int start, int length) throws SAXException {
	
	
	}
	
	//�ݴ� �±��� ���� �߰ߵǸ� ȣ��Ǵ� �޼���
	public void endElement(String uri, String localName, String qName) throws SAXException {
	
	
	}
}
