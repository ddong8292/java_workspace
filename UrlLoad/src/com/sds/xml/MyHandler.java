/*
 * SAX �Ľ� ����� �� �±׿�Ҹ� ��� �޸𸮿� �ø��� ����� �ƴ϶�, �� �±׿�Ұ� �߰ߵɶ�����
 * �����ڿ��� �̺�Ʈ�� ���� �����Ѵ�. ���� �޸𸮿� �ö���� ��ü�� ���� ����.
 * ���� �����ڰ� �� �̺�Ʈ Ÿ�̹��� ��ġ�� �ʰ� ������ ó���� ����� �Ѵ�.
 * */
package com.sds.xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.sds.table.MyModel;

public class MyHandler extends DefaultHandler {
	MyModel model;
	
	public MyHandler(MyModel model) {
		this.model=model;
	}
	
	@Override
	public void startDocument() throws SAXException {
		System.out.println("������ ���ۉ�׿�");
		
	}
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		System.out.print("<"+qName+">");
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String data=new String(ch,start,length);
		System.out.print(data);
		
	}
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		System.out.println("</"+qName+">");
	}
	
	
	
}
















