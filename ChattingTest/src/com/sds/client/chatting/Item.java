/*
회원 1명을 포함하는 아이템 클래스 정의!!
*/
package com.sds.client.chatting;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Item extends JPanel{
	JLabel la_profile;
	JLabel la_status;
	ImageIcon icon;

	//객체 생성시 이미지 경로와 상태메세지를 넘겨받자!!
	public Item(String path, String status){
		URL url=this.getClass().getClassLoader().getResource(path);
		icon = new ImageIcon(url);
		la_profile = new JLabel(icon);
		la_status = new JLabel(status);
		
		la_status.setAlignmentX(RIGHT_ALIGNMENT);
		setLayout(new BorderLayout());
		add(la_profile, BorderLayout.WEST); //서쪽에 부착
		add(la_status);//센터에 부착
		setPreferredSize(new Dimension(400, 60));
	}
}













