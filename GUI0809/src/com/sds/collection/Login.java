package com.sds.collection;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableModel;

public class Login extends JFrame implements ActionListener{
	JPanel pan1;
	JPanel pan2;
	JPanel pan3;
	JLabel la1;
	JLabel la2;
	JLabel la3;
	JTextField txt1;
	JTextField txt2;
	JTextField txt3;
	JButton bt1;
	JButton bt2;
	JTable table;
	JScrollPane scroll;
	
	
	public Login(){
		pan1=new JPanel();
		pan2=new JPanel();
		pan3=new JPanel();
		la1=new JLabel("이름");
		la2=new JLabel("ID");
		la3=new JLabel("PWD");
		txt1=new JTextField(8);
		txt2=new JTextField(8);
		txt3=new JTextField(8);
		bt1=new JButton("등록");
		bt2=new JButton("목록");
		table=new JTable(new Data());
		scroll=new JScrollPane(table);
		
		pan1.add(la1);
		pan1.add(txt1);
		pan1.add(la2);
		pan1.add(txt2);
		pan1.add(la3);
		pan1.add(txt3);
		pan1.add(bt1);
		pan1.add(bt2);
		
		pan1.setLayout(new FlowLayout());
		pan2.add(pan1, BorderLayout.NORTH);
		pan1.setPreferredSize(new Dimension(100, 800));
		pan3.add(scroll);
		add(pan2,BorderLayout.WEST);
		add(pan3, BorderLayout.CENTER);
		
		setSize(800, 800);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e){
		System.out.println();
	
	}

	public static void main(String[] args){
		new Login();
	}
}
