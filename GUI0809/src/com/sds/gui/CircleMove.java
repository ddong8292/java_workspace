package com.sds.gui;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CircleMove extends JFrame{
	JPanel p_north;
	JButton bt_left, bt_right, bt_up, bt_down;
	Canvas can;
	JButton[] btn= new JButton[4];
	int x=100;//��������� �����͸�Ŭ������ ���ٰ����ϴ�.
	int y=100;
	
	public CircleMove(){
		p_north=new JPanel();
		bt_left=new JButton("LEFT");
		bt_right=new JButton("RIGHT");
		bt_up=new JButton("UP");
		bt_down=new JButton("DOWN");
		
		btn[0]=bt_left;
		btn[1]=bt_right;
		btn[2]=bt_up;
		btn[3]=bt_down;
		
		can=new Canvas(){
			public void paint(Graphics g){
				
				g.drawOval(x, y, 40, 40);
			}
		};
		
		add(can);
		
		p_north.add(bt_left);
		p_north.add(bt_right);
		p_north.add(bt_up);
		p_north.add(bt_down);
		
		add(p_north, BorderLayout.NORTH);
		final int k=9;//�����͸� Ŭ������ ���������� �����Ҽ� ������, final�� ������ ���� ����.
		//��ư�� �����ʿ��� ����
		for(int i=0; i<btn.length; i++){
			btn[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					//System.out.println(k);
					Object obj=e.getSource();
					JButton b=(JButton)obj;
					System.out.println(b.getText()+"����");
					
					switch (b.getText()) {
					case "Left":moveHorizon(-5);break;
					case "RIGHT":moveHorizon(5);break;
					case "UP":moveVertical(-5);break;
					case "DOWN":moveVertical(5);break;
						
						
					default:
						break;
					}
				}
			});
		}
		
		setSize(600,600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	//�¿� �̵� �޼���
	public void moveHorizon(int x){
		this.x+=x;
		can.repaint();
	}
	
	//���Ʒ� �̵� �޼���
	public void moveVertical(int y){
		this.y+=y;
		can.repaint();
	}
	
	public static void main(String[] args) {

		new CircleMove();
	}

}
