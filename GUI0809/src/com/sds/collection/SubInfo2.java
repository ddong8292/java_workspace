package com.sds.collection;

import javax.swing.table.AbstractTableModel;

public class SubInfo2 extends AbstractTableModel{
	String[] column={"�̸�","����","����"};
	String[][]data={
			{"����ȫ","20","����"},
			{"����ȫ2","25","����"},
			{"����ȫ3","30","����"},
			{"����ȫ4","27","����"}
	};
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
