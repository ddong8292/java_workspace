package com.sds.collection;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class MemberApp extends JFrame implements ActionListener{
	JPanel p_west;
	JLabel la_id, la_name, la_pwd;
	JTextField t_id, t_name, t_pwd;
	JButton bt_regist, bt_list;
	JTable table;
	JScrollPane scroll;
	MemberAppModel model;
	
	
	public MemberApp() {
		p_west = new JPanel();
		
		la_id = new JLabel("ID");
		la_name = new JLabel("이름");
		la_pwd = new JLabel("비번");
		
		t_id = new JTextField(10);
		t_name = new JTextField(10);
		t_pwd = new JTextField(10);
		
		bt_regist = new JButton("등록");
		bt_list = new JButton("목록");
		
		table = new JTable(model=new MemberAppModel());
		scroll = new JScrollPane(table);
		
		p_west.add(la_id);
		p_west.add(t_id);
		p_west.add(la_name);
		p_west.add(t_name);
		p_west.add(la_pwd);
		p_west.add(t_pwd);
		p_west.add(bt_regist);
		p_west.add(bt_list);
		
		p_west.setPreferredSize( new Dimension(150,600));
		add(p_west, BorderLayout.WEST);
		add(scroll);
		
		bt_regist.addActionListener(this);
		bt_list.addActionListener(this);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(700,600);
		setVisible(true);
	}
	public void regist(){
		String id=t_id.getText();
		String name=t_name.getText();
		String pwd = t_pwd.getText();
		
		String[] record = {id, name,pwd};
		model.data.add(record);
		
		model.fireTableDataChanged();
	}
	public void getList(){
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj=e.getSource();
		if(obj == bt_regist){
			regist();
		}else if(obj == bt_list){
			getList();
		}
	}
	public static void main(String[] args) {
		new MemberApp();

	}

}
