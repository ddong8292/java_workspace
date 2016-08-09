package com.sds.collection;

import javax.swing.table.AbstractTableModel;

public class SubInfo2 extends AbstractTableModel{
	String[] column={"이름","나이","성별"};
	String[][]data={
			{"박찬홍","20","남자"},
			{"박찬홍2","25","남자"},
			{"박찬홍3","30","여자"},
			{"박찬홍4","27","남자"}
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
