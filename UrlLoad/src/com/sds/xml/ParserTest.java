/*
 * �� ������ (�ý��� ����� Ʋ��) ������ ��ȯ�� ���� ���Ǵ�
 * ������ �ؽ�Ʈ ��� �����ͺ��̽��� xml �� �ڹٿ��� �����
 * ����!!
 * 
 * �Ϲ����� ���α׷����� �Ľ��ϴ� ��� ũ�� 2������ �ִ�!
 * 1.DOM - html ������ �� �ִ� �������̽�
 *              ����: ��üȭ���� ������ �� �־ ��ü���� ���
 *                       ������� ���α׷��� ����..
 *              ����: �޸𸮻�뷮�� �����Ƿ� Ư��, ����ϱ���
 *                       �Ҹ��ϴ�.
 *                   
 * 2.SAX -  ����ΰ� �� �±׸� �߰��Ҷ����� ������ �̺�Ʈ��
 *               �߻��ϴ� ����̰�, �������� �̺�Ʈ Ÿ�̹��� ���
 *               ���� ���ϴ� ó���� ������ϴ� ���...
 *               ����: �ӵ��� ������ (�޸𸮸� �� ��ƸԴ´�) 
 *               ����: ���α׷��� ��ٷӴ�..
 * */

package com.sds.xml;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class ParserTest {
	
	//SAXParser�� �߻�Ŭ�����̹Ƿ� ���� new �Ҽ�����, �Ʒ���
	//SAXParserFactory ��ü�� ���� �ν��Ͻ��� ���;� �Ѵ�..
	SAXParserFactory factory;
	String path="C:/java_workspace/UrlLoad/res/member.xml"; 
	//MyHandler handler = new MyHandler();
	
	public ParserTest() {
		factory=SAXParserFactory.newInstance();
		try {
			SAXParser parser=factory.newSAXParser();
			
			//� ������ �ؼ�����, �� �̺�Ʈ ó���ڴ� ��������
			//��������!!
			parser.parse(new File(path), handler);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new ParserTest();

	}

}








