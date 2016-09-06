package com.sds.web;

import java.awt.Color;
import java.awt.Dimension;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ImageLoad extends JFrame{
	JPanel p_container;
	JScrollPane scroll;
	
	public ImageLoad() {
		p_container=new JPanel();
		scroll=new JScrollPane(p_container);
		p_container.setBackground(Color.YELLOW);
		p_container.setPreferredSize(new Dimension(250, 150*20));
		
		//라벨을 여러개 만들되 그 라벨에 이미지 아이콘을 Url로 가져오자
		URL url;
		try {
			for(int i=0; i<20;i++){
				url = new URL("http://70.12.112.110:9090/images/kim.jpg");
				ImageIcon icon=new ImageIcon(url);
				JLabel la_img=new JLabel(icon);
				p_container.add(la_img);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		add(scroll);
		setBounds(300,100,300,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new ImageLoad();
	}

}
