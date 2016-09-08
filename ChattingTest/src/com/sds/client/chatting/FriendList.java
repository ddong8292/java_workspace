package com.sds.client.chatting;

import java.awt.Dimension;

import javax.swing.JPanel;

public class FriendList extends JPanel{
	String[] path={
		"profile.png",
		"profile.png",
		"profile_default.png",
		"profile_default.png"
	};
	String[] status={
		"坷疵 泪荐沤.",
		"国结2斥",
		"过牢技 吵何扁埃",
		"官恩家府"
	};
	
	public FriendList() {
		setPreferredSize(new Dimension(400, 450));
		
		for(int i=0;i<4;i++){
			Item item = new Item(path[i], status[i]);
			add(item);
		}
	}
}





