package com.sds.collection;

import javax.swing.table.AbstractTableModel;

public class SubInfo extends AbstractTableModel {
	String[] column={"��ȣ","�̸�","����","����"};
	String[][]data={
			{"1","�̻��","����","2"},
			{"2","�̻��2","����","1"},
			{"3","�̻��3","����","4"},
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
