package com.sds.collection;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

public class Information extends JFrame{
	JPanel pan1;
	JPanel pan2;
	JPanel pan3;
	Choice ch;
	JTable ta;
	JScrollPane scroll;
	TableModel model;
	
	public Information(){
		pan1=new JPanel();
		pan2=new JPanel();
		pan3=new JPanel();
		ch=new Choice();
		ta=new JTable();
		scroll=new JScrollPane(ta);
		
		ch.add("선택하세요");
		ch.add("애완동물");
		ch.add("회원정보");
		ch.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				//System.out.println(e.getItem());
			
				if("애완동물"==e.getItem()){
					ta.setModel(new SubInfo());
				
				}else if("회원정보"==e.getItem()){
					ta.setModel(new SubInfo2());
				
				}
				ta.updateUI();
			}
		});
		pan2.add(ch);
		pan1.add(pan2);
		pan1.add(pan2, BorderLayout.NORTH);
		
		
		pan3.add(scroll);
		add(pan1, BorderLayout.WEST);
		add(pan3, BorderLayout.CENTER);
		
		setSize(700, 600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
	}
	public static void main(String[] args) {
		new Information();

	}

}
