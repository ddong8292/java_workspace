package com.sds.collection;

import javax.swing.table.AbstractTableModel;

public class Data extends AbstractTableModel{
	String[]column={"�̸�","���̵�","��й�ȣ"};
	String[][]data={};
	
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return data.length;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return column.length;
	}

	@Override
	public Object getValueAt(int row, int col) {
		
		return data[row][col];
	}
	@Override
	public String getColumnName(int col) {
		return column[col];
	}
}
