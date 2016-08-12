package com.sds.json;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Profile extends JPanel {
	JPanel p_west;//캔버스를 안게될 패널
	Canvas can;
	JPanel p_center;
	Toolkit kit;
	Image img;
	JLabel la_name;
	JLabel la_gender;
	JLabel la_age;
	
	public Profile(String url){
		p_west=new JPanel();
		kit= Toolkit.getDefaultToolkit();
		img=kit.getImage(url);
		can=new Canvas(){
			public void paint(Graphics g){
				g.drawImage(img, 5, 0, 140,120,this);
			}
		};
		p_center=new JPanel();
		la_name=new JLabel("이름");
		la_gender=new JLabel("성별");
		la_age=new JLabel("나이");
		
		setLayout(new BorderLayout());
		
		//캔버스의 크기설정
		can.setPreferredSize(new Dimension(150,120));
		//can.setBackground(Color.BLACK);
		
		//p_west에 캔버스 부착하고 p_west를 west영역에 부착
		p_west.setPreferredSize(new Dimension(150,120));
		p_west.add(can);
		add(p_west,BorderLayout.WEST);
		
		//센터 패널에 그리드 레이아웃 사용
		p_center.setLayout(new GridLayout(3, 1));
		p_center.setPreferredSize(new Dimension(400, 120));
		p_center.add(la_name);
		p_center.add(la_gender);
		p_center.add(la_age);
		
		//센터에 p_center 부착!
		add(p_center);
		p_center.setBackground(Color.CYAN);
		p_center.setPreferredSize(new Dimension(550, 120));
	}
	
}
