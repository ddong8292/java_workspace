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
		
		// url�̶� �ڿ��� ��ġ�� �ǹ��Ѵ�!! web������ http://~~�̶�� ������ 
		//���뿡���� �ý��۳������� �ڿ��� ��ġ�� ���Ѵ�!
		img=getImage("ship.png");
		
	}
	public void tick() {
		x+=velX;
		y+=velY;
		
		//�ǽð� �簢���� ��ġ�� �ٲ�� �Ѵ�! �׷��� ���ΰ��� ����ٴϴϱ�!�׷��� �浹�˻簡 �����ϴϱ�!
		rect.setBounds(x, y, width, height);
	}
	public void render(Graphics g) {
		
		g.drawImage(img, x, y, width, height, null);
		
		showRect(g);
		
		
	}
	public void fire() {//�Ѿ˹߻�
		Bullet bullet=new Bullet(x+width, y+(height/2), 50, 15, "bullet", objectManager);
		objectManager.addObject(bullet);
	}

}
