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

public class JTableApp extends JFrame implements ItemListener{
	JPanel p_west;
	Choice ch;
	JTable table;
	JScrollPane scroll;
	TableModel model;
	
	public JTableApp() {
		p_west = new JPanel();
		ch = new Choice();
		
		ch.add("▼선택");
		ch.add("애완동물");
		ch.add("회원정보");
		
		p_west.add(ch);
		
		table = new JTable();
		scroll = new JScrollPane(table);
		
		add(p_west, BorderLayout.WEST);
		add(scroll);
		
		ch.addItemListener(this);
		
		setVisible(true);
		setSize(700, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void itemStateChanged(ItemEvent e) {
		Object obj=e.getItem();
		
		if(obj.equals("▼선택")){
			JOptionPane.showMessageDialog(this, "원하는 아이템 선택하세요");
			return;
		}else if(obj.equals("애완동물")){
			table.setModel(model=new PetModel());
		}else if(obj.equals("회원정보")){
			table.setModel(model=new MemberModel());
		}
		table.updateUI(); //ui  갱신~! refresh!!
	}
	
	public static void main(String[] args) {
		new JTableApp();

	}


}





