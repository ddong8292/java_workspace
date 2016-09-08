package com.sds.stream;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;

public class MyLabel extends JLabel{
	
	public MyLabel(int i, int fontSize){
		this.setPreferredSize(new Dimension(35, 35));
		this.setFont(new Font("arial black", Font.PLAIN, fontSize));
		this.setText(Integer.toString(i));
	}
}
