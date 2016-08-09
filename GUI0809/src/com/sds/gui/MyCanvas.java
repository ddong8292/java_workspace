package com.sds.gui;

import java.awt.Canvas;
import java.awt.Graphics;

public class MyCanvas extends Canvas{
	public void paint(Graphics g){
		
		g.drawOval(100, 100, 40, 40);
	}
}
