package com.sds.game;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class GameWindow extends JFrame implements ActionListener{
	//���ӿɼ�-���ӽ���, ����, ����
	//����
	Gamepanel gamepanel;
	JMenu[] menu;
	JMenuBar bar;
	JMenuItem[]item;
	KeyBoard keyBoard;
	public GameWindow() {
		bar=new JMenuBar();
		menu=new JMenu[2];
		item=new JMenuItem[3];
		
		menu[0]=new JMenu("���ӿɼ�");
		menu[1]=new JMenu("����");
	
		item[0]=new JMenuItem("���ӽ���");
		item[1]=new JMenuItem("����");
		item[2]=new JMenuItem("����");
		
		menu[0].add(item[0]);
		menu[0].add(item[1]);
		menu[0].add(item[2]);
		
		bar.add(menu[0]);
		bar.add(menu[1]);
		
		setJMenuBar(bar);
		
		gamepanel=new Gamepanel();
		
		add(gamepanel);
		
		//setBackground(Color.BLACK );
		pack();
		
		//�����ʿ� �޴��� ����
		for(int i=0; i<item.length;i++){
			item[i].addActionListener(this);
			
		}
		addKeyListener(keyBoard = new KeyBoard(gamepanel.objectManager));
		
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj=e.getSource();
		if(obj==item[0]){
			gamepanel.startGame();
		}else if(obj==item[1]){
			gamepanel.pauseGame();
		}else if(obj==item[2]){
			gamepanel.exitGame();
		}
	}
	public static void main(String[] args) {
		new GameWindow();

	}

}
