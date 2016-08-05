package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class HomeWork extends JFrame{
	JTextField tf1;
	JTextField tf2;
	JLabel txt1;
	JLabel txt2;
	JLabel txt3;
	JButton bt1;
	JButton bt2;
	JPanel pan;
	JPanel pan2;
	JPanel pan3;
	JPanel pan4;
	
	public HomeWork(){
		
		tf1= new JTextField(15);
		tf2= new JTextField(15);
		txt1= new JLabel("로그인", JLabel.CENTER);
		txt2= new JLabel("ID");
		txt3= new JLabel("PASSWORD");
		bt1=new JButton("Login");
		bt2=new JButton("Sign");
		pan=new JPanel();
		pan2=new JPanel();
		pan3=new JPanel();
		pan4=new JPanel();
				
		//상단 "로그인"
		add(txt1,BorderLayout.NORTH);
		txt1.setPreferredSize(new Dimension(300, 50));
		
		//하단 "버튼"
		add(pan, BorderLayout.SOUTH);
		pan.setPreferredSize(new Dimension(300, 50));
		pan.add(bt1);
		pan.add(bt2);

		//중단
		
		add(pan2, BorderLayout.CENTER);
		pan3.add(txt2);
		txt2.setPreferredSize(new Dimension(100, 50));
		pan3.add(tf1);
		tf1.setBackground(Color.yellow);
		
		pan4.add(txt3);
		txt3.setPreferredSize(new Dimension(100, 50));
		pan4.add(tf2);	
		tf2.setBackground(Color.yellow);
		
		
		pan2.add(pan3, BorderLayout.NORTH);
		pan2.add(pan4,BorderLayout.SOUTH);
		setResizable(false);
		
		
		setSize(300, 300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	public static void main(String[] args) {
		new HomeWork();

	}

}
