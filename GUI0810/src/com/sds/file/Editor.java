package com.sds.file;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Editor extends JFrame{
	JMenuBar bar;
	
	JMenu[] menus;
	String[] menu_title={"파일","편집","서식","보기","도움말"};
	ImageIcon[] icons;
	String[] iconPath={
		"C:/java_workspace/GUI0810/res/file.png",	
		"C:/java_workspace/GUI0810/res/edit.png",	
		"C:/java_workspace/GUI0810/res/form.png",	
		"C:/java_workspace/GUI0810/res/view.png",	
		"C:/java_workspace/GUI0810/res/help.png"
	};
	JTextArea area;
	JScrollPane scroll;
	JPanel p_line;
	JPanel p_center;
	
	public Editor() {
		bar =  new JMenuBar();
		bar.setBackground(Color.WHITE);
		menus = new JMenu[5];
		icons=new ImageIcon[menu_title.length];
		
		for(int i=0;i<menu_title.length;i++){
			icons[i]=new ImageIcon(iconPath[i]);
			Image img=icons[i].getImage();
			Image scaledImg=img.getScaledInstance(20, 20, Image.SCALE_DEFAULT);
			icons[i].setImage(scaledImg);
			
			menus[i] = new JMenu();
			menus[i].setIcon(icons[i]);
			bar.add(menus[i]);
			
		}
		
		setJMenuBar(bar);
		area = new JTextArea();
		area.setFont(new Font("돋움", Font.PLAIN, 20));
		scroll = new JScrollPane(area);
		
		p_line = new JPanel();
		p_line.setPreferredSize(new Dimension(20, 600));
		
		for(int i=1;i<=30;i++){
			p_line.add(new JLabel(Integer.toString(i)));
		}
		
		p_center = new JPanel();
		p_center.setLayout( new BorderLayout());
		p_center.add(p_line, BorderLayout.WEST);
		p_center.add(scroll);
		
		add(p_center);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setSize(700, 600);
		
	}
	public static void main(String[] args) {
		new Editor();
	}

}
