package com.sds.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

public class Ship extends GameObject{
	Image img;
	
	/*
	 * public ship(){
	 * 		super();
	 * }
	 * */
	
	public Ship(int x, int y, int width, int height, String name, ObjectManager objectManager) {
		super(x, y, width, height, name, objectManager);
		
		// url이란 자원의 위치를 의미한다!! web에서는 http://~~이라고 하지만 
		//응용에서는 시스템내에서의 자원의 위치를 말한다!
		img=getImage("ship.png");
		
	}
	public void tick() {
		x+=velX;
		y+=velY;
		
		//실시간 사각형의 위치를 바꿔야 한다! 그래야 주인공을 따라다니니깐!그래야 충돌검사가 가능하니깐!
		rect.setBounds(x, y, width, height);
	}
	public void render(Graphics g) {
		
		g.drawImage(img, x, y, width, height, null);
		
		showRect(g);
		
		
	}
	public void fire() {//총알발사
		Bullet bullet=new Bullet(x+width, y+(height/2), 50, 15, "bullet", objectManager);
		objectManager.addObject(bullet);
	}

}
