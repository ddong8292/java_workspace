/*
 * xml�� �о���� ����� JTable�� ����غ���!!
 * 
 * */
package com.sds.table;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
public class XmlTable extends JFrame{
	JTable table;
	JScrollPane scroll;
	MyModel model;
	
	public XmlTable() {
		table=new JTable(model=new MyModel());
		scroll=new JScrollPane(table);
		add(scroll);
		setSize(300,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new XmlTable();

	}

}
