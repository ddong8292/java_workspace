/*
 * 컴포넌트 중 canvas를 상속받아 개발자가 주도하여 그림을 그려보도록 한다!
 * paint 메서드를 재정의 해보자!
 * */
package com.sds.gallery;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JOptionPane;

public class XCanvas extends Canvas{
	Toolkit kit=Toolkit.getDefaultToolkit();//추상클래스임!
	Image[] imgs;//추상클래스임!
	String[] path={"C:/java_workspace/GUI0808/res/1.png",
							"C:/java_workspace/GUI0808/res/2.png",
							"C:/java_workspace/GUI0808/res/3.png",
							"C:/java_workspace/GUI0808/res/kim.jpg",
							};
	int count=0;
	
	public XCanvas() {
		imgs=new Image[path.length];
		for(int i=0; i<imgs.length; i++){
			imgs[i]=kit.getImage(path[i]);
		}
		
	}
	@Override
	public void paint(Graphics g) {
		g.drawImage(imgs[count], 0, 0, 700,800, this);
	}
}
