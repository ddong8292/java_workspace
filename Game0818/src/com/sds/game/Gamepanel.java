package com.sds.game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Gamepanel extends JPanel implements Runnable{
	public static final int WIDTH=1024;
	public static final int HEIGHT=768;
	Thread gameThread;
	boolean running=true;
	
	Ship ship;
	ObjectManager objectManager;
	
	public Gamepanel() {	
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		
		objectManager=new ObjectManager();
		createShip();
		createEnemy();
		createBlock();
	}
	
	//���ΰ� ���� �޼���
	public void createShip(){
		ship=new Ship(0, 0, 50, 50, "ship",objectManager);
		objectManager.addObject(ship);
		
	} 
	//���� ���� �޼���
	public void createEnemy(){
		for(int i=0;i<7;i++){
			Random random=new Random();
			int n=random.nextInt(9);
			Enemy enemy = new Enemy(WIDTH-100 , n*70 , 70, 70, "Enemy", objectManager);
			objectManager.addObject(enemy);
		}
		
	}
	public void createBlock(){
		//����
		for(int i=0; i<20; i++){
			Block block=new Block(i*50, 0, 50, 50, "block", objectManager);
			objectManager.addObject(block);
			
		}
		
		//�Ʒ���
		for(int i=0; i<20; i++){
			Block block=new Block(i*50, HEIGHT-50, 50, 50, "block", objectManager);
			objectManager.addObject(block);
		}
	}
	protected void paintComponent(Graphics g) {
		
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, WIDTH,HEIGHT);
		//System.out.println("���� ���� �۵� ��..");
		//��� ���� ������Ʈ�� tick(), rander()ȣ��
		for(int i=0;i<objectManager.objectList.size();i++){
			GameObject obj=objectManager.objectList.get(i);
			obj.tick();
			obj.render(g);
		}
	}
	
	//���ӽ���(������ ���� �� ����)
	public void startGame() {
		if(gameThread!=null){
			return;
		}
		running=true;
		gameThread=new Thread(this);
		gameThread.start();//Runnable �������� ���Խ�Ű��!
	}
	//���� ����(������ ����)
	public void pauseGame() {
		running=false;
		gameThread=null;

	}
	//��������(���μ�������)
	public void exitGame(){
		System.exit(0);//0Ȥ�� 0���� ������ �ȴ�!
		
	}
	public void run() {
		while(running){
			//���⼭ ������ ��� ��ü�� �۵�!! tick(), render()
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//System.out.println("���� ���� �۵� ��..");
			//��� ������Ʈ���� ������� tick(), render() ȣ��!
			repaint();//update()�� ȣ���ϰ�--> paint()�� ȣ���Ѵ�!!
		}
		
	}
	
}
