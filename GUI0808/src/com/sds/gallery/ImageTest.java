/*
 * �ڹ��� ��� GUI ������Ʈ�� ������ �׸��� ��ü�� �Ǿ� �����θ� �׸���. �̋� �׸� �׸��� ������
 * paint �޼���� ǥ���Ǹ�, �� paint �޼����� �Ű������� �ȷ�Ʈ������ ��ü�� Graphics ��ü�� �μ��� ���޵Ǿ� ����.
 * ex)��ư�� ������ �׸��� ����.
 * */
package com.sds.gallery;

import java.awt.Canvas;//�ƹ��͵� �׷��� ���� ���� ��ȭ�� ĵ����.

import javax.swing.JButton;
import javax.swing.JFrame;

public class ImageTest extends JFrame{
	MyButton bt;
	MyCanvas can;
	
	public ImageTest(){
		bt=new MyButton("Ŀ���� ��ư");
		can= new MyCanvas();
		
		
		add(bt);
		add(can);
		setSize(300, 400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	public static void main(String[] args) {
		new ImageTest();
	}

}
