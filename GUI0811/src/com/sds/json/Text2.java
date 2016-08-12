package com.sds.json;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Text2 extends JPanel{
	Canvas can;
	JLabel laName;
	JLabel laGender;
	JLabel laAge;
	JPanel pan_left;
	JPanel pan_big;
	JPanel pan_ri;

	public Text2(String name, String gender, String age, String url){
		can=new Canvas(){
			Toolkit tk = Toolkit.getDefaultToolkit();
			@Override
			public void paint(Graphics g) {
				Image img = tk.getImage(url);
				g.drawImage(img, 0, 0, 150, 150, this);
			}
		};
		laName=new JLabel("이름: "+name);
		laGender=new JLabel("성별: "+gender);
		laAge=new JLabel("나이: "+age);
		pan_left=new JPanel();
		pan_big=new JPanel();
		pan_ri=new JPanel(new GridLayout(3, 1));
		
		can.setPreferredSize(new Dimension(150, 150));
		pan_left.add(can);
		
		pan_ri.add(laName);
		pan_ri.add(laGender);
		pan_ri.add(laAge);
		
		setLayout(new GridLayout(0, 1));
		pan_big.add(pan_left, BorderLayout.WEST);
		pan_big.add(pan_ri, BorderLayout.CENTER);
		
		add(pan_big);
		
		setSize(300,400);
		setVisible(true);		
	}
}
