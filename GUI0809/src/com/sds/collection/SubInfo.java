package com.sds.collection;

import javax.swing.table.AbstractTableModel;

public class SubInfo extends AbstractTableModel {
	String[] column={"번호","이름","성별","나이"};
	String[][]data={
			{"1","이상신","수컷","2"},
			{"2","이상신2","암컷","1"},
			{"3","이상신3","수컷","4"},
	};
	
	@Override
	public int getRowCount() {
		return data.length;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return column.length;
	}

	@Override
	public Object getValueAt(int row, int col) {
		return data [row][col];
	}
	@Override
	public String getColumnName(int col) {
		return column[col];
	}

}
