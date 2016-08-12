package com.sds.stream;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ThumbnailGallery extends JFrame{
	JPanel p_left , p_right;
	Image currentImg;//유저가 지금 선택한 썸네일의 이미지!
	String[] url={
			"C:/java_workspace/GUI0811/res/1.png",
			"C:/java_workspace/GUI0811/res/2.png",
			"C:/java_workspace/GUI0811/res/3.png",
			"C:/java_workspace/GUI0811/res/4.png"};
	MyCanvas []can= new MyCanvas[url.length];
	
	public ThumbnailGallery(){
		p_left=new JPanel();
		for(int i=0; i<url.length; i++){

			can[i]=new MyCanvas(url[i]);
			can[i].setPreferredSize(new Dimension(50,50));
			//System.out.println(can[i]);
			p_left.add(can[i]);
			
		}
		currentImg= can[0].img;
		p_right=new JPanel(){
			
			public void paint(Graphics g) {
				g.drawImage(currentImg, 0, 0, 400,350, this);
				
			}
		};
		p_left.setPreferredSize(new Dimension(500, 300));
		p_right.setPreferredSize(new Dimension(380, 380));
		//큰이미지 적용
		
		
		p_left.setBackground(Color.GREEN);
		p_right.setBackground(Color.YELLOW);
		
		//GridLayout 적용
		setLayout(new GridLayout(1,2));
		
		add(p_left);
		add(p_right);
		
		setSize(800,600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	
	public static void main(String[] args) {
		new ThumbnailGallery();
	}

}
