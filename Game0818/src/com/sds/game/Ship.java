package com.sds.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class Ship extends GameObject {
	Image img;
	int t;
	
	public Ship(int x, int y, int width, int height, String name,ObjectManager objectManager) {
		super(x, y, width, height, name, objectManager);
		
		//URL 이란 자원의 위치를 의미한다!!web--> http://~
		//응용--> 시스템내에서의 자원의 위치!!
		img=getImage("spaceship.png");
	}

	public void tick() {
		x+=velX;
		y+=velY;
		
		//실시간 사각형의 위치를 바꿔야 한다!~~~
		//그래야 주인공을 따라다니니깐...그래야 충돌검사가 가능..
		rect.setBounds(x, y, width, height);
	}

	public void render(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
		g.drawImage(img, x, y, width, height, null);
		
		showRect(g);
	}
	
	//총알 발사!!
	public void fire(){
		Bullet bullet  = new Bullet(x+width, y+(height/2), 50, 15, "Bullet", objectManager);
		objectManager.addObject(bullet);
	}
	


}











