/*
 * ���ӿ� ���� Ű���� �̺�Ʈ�� �����Ͽ� ó���ϴ� ��ü 
 * */
package com.sds.game;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
public class KeyBoard extends KeyAdapter{
	ObjcetManager objcetManager;
	
	public KeyBoard(ObjcetManager objcetManager) {
		this.objcetManager=objcetManager;
	}
	
	public void keyPressed(KeyEvent e) {
		int key=e.getKeyCode();
		
		
		for(int i=0; i<objcetManager.objcetList.size(); i++){
			GameObject obj=objcetManager.objcetList.get(i);
			
			if(obj.name.equals("Hero")){//���ΰ��� ��츸..
				switch(key){
					case KeyEvent.VK_LEFT:obj.velX=-2;break;
					case KeyEvent.VK_UP:obj.velY=-2;break;
					case KeyEvent.VK_RIGHT:obj.velX=2;break;
					case KeyEvent.VK_DOWN:	obj.velY=2;break;
					case KeyEvent.VK_SPACE:	;break;
				}
			}
		}
	}
	
	public void keyReleased(KeyEvent e) {
	int key=e.getKeyCode();
		
		
		for(int i=0; i<objcetManager.objcetList.size(); i++){
			GameObject obj=objcetManager.objcetList.get(i);
			
			if(obj.name.equals("Hero")){//���ΰ��� ��츸..
				switch(key){
					case KeyEvent.VK_LEFT:obj.velX=0;break;
					case KeyEvent.VK_UP:obj.velY=0;break;
					case KeyEvent.VK_RIGHT:obj.velX=0;break;
					case KeyEvent.VK_DOWN:	obj.velY=0;break;
					case KeyEvent.VK_SPACE:	;break;
				}
			}
		}
	}
	
}
