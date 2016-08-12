/*
 * ����Ͽ� ���� �˹����̸�, ����� ���� �ν��Ͻ��� ����ǹǷ� �� ���뼺�� �����Ƿ� �����͸��ٴ�
 * .java �ҽ��� ������ �����Ű��!
 * */
package com.sds.stream;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import org.omg.CORBA.PUBLIC_MEMBER;

public class MyCanvas extends Canvas implements MouseListener{
	Toolkit kit;
	Image img;
	ThumbnailGallery gallery;
	
	public MyCanvas(String url){
		System.out.println(url);
		this.gallery=gallery;
		kit=Toolkit.getDefaultToolkit();
		img=kit.getImage(url);
		
		this.addMouseListener(this);
		
	}	
	public void paint(Graphics g) {
		g.drawImage(img, 0,0, 50,50,this);
	
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("���콺 ������?");
		
		//�����찡 ������� ū �̹����� ���� ĵ������ �̹����� ��ü����!
		gallery.currentImg=img;
		gallery.repaint();
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
