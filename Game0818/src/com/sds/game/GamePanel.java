package com.sds.game;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{
	public static final int WIDTH=1024;
	public static final int HEIGHT=768;
	Thread gameThread;
	boolean running=true;	
	Ship ship;
	ObjectManager objectManager;
	
	
	public GamePanel() {
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		
		objectManager = new ObjectManager();
		createShip();
		createEnemy();
		createBlock();
	}
	
	//주인공 등장 메서드 
	public void createShip(){
		ship = new Ship(0, 0, 100,40, "Ship",objectManager);
		objectManager.objectList.add(ship);
	}
	
	//적군 등장 메서드 
	public void createEnemy(){
		Random random = new Random();
		
		for(int i=0;i<7;i++){
			int n=random.nextInt(9);
			Enemy enemy = new Enemy(WIDTH-100 , n*50 , 100, 85, "Enemy", objectManager);
			objectManager.addObject(enemy);
		}
	}
	
	//블럭 생성 메서드
	public void createBlock(){
		//윗블럭
		for(int i=0;i<20;i++){
			Block block  = new Block(i*50, 0, 50, 50, "Block", objectManager);
			objectManager.addObject(block);
		}
		
		//아랫블럭
		for(int i=0;i<20;i++){
			Block block  = new Block(i*50, HEIGHT-50, 50, 50, "Block", objectManager);
			objectManager.addObject(block);
		}
		
	}
	
	protected void paintComponent(Graphics g) {
		/*		
		try {
			Image img=ImageIO.read(this.getClass().getClassLoader().getResource("space.jpg"));
			g.drawImage(img, 0, 0, WIDTH, HEIGHT, this);
		} catch (IOException e) {
			e.printStackTrace();
		}
 		*/
		//모든 게임 오브젝트의  tick(), render() 호출
		for(int i=0;i<objectManager.objectList.size();i++){
			GameObject obj=objectManager.objectList.get(i);
			obj.tick();
			obj.render(g);
		}
		
	}
	
	//게임시작 (쓰레드 생성 및 시작) 
	public void startGame(){
		if(gameThread!=null){
			return;
		}
		running=true;
		gameThread = new Thread(this);
		gameThread.start(); //Runnable 영역으로 진입시키기!!
	}
	//게임 멈춤 ( 쓰레드 종료 ) 
	public void pauseGame(){
		running=false;
		gameThread=null;
	}
	
	//게임 종료 ( 프로세스 종료)
	public void exitGame(){
		System.exit(0);
	}
	
	public void run() {
		while(running){
			//여기서 게임의 모든 객체를 작동!!! tick(), render()
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//모든 오브젝트들을 대상으로 tick(), render()
			repaint(); //update() --> paint()
		}
	}
}










