package com.sds.game;

import java.awt.Graphics;
import java.awt.Image;

import javax.naming.spi.DirStateFactory.Result;

public class Bullet extends GameObject{
	Image img;
	public Bullet(int x, int y, int width, int height, String name,ObjectManager objectManager) {
		super(x, y, width, height, name, objectManager);
		img=getImage("bullet.png");
		velX=5;
	}

	public void tick() {
		x+=velX;
		rect.setBounds(x, y, width, height);
		
		//�Ѿ˰� ������� �浹�˻�~!!
		hitTest();
	}
	public boolean hitTest(){
		for(int i=0; i<objectManager.objectList.size(); i++){
			GameObject obj=objectManager.objectList.get(i);
		
			if(obj.name.equals("Enemy")){
				//������ ���� �浹�˻�
				boolean result=this.rect.intersects(obj.rect);
				if(result){
					//System.out.println("�浹�߾�!");
					objectManager.removeObject(this);
					objectManager.removeObject(obj);
				}
			}
			
		}
		return false;
	}
	public void render(Graphics g) {
		g.drawImage(img, x, y, width, height, null);
		showRect(g);
	}
}