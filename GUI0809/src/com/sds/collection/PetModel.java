/*
 * JTable에 보여질 데이터 중 애견관련 데이터를 처리하는 TableModel
 * */
package com.sds.collection;

import javax.swing.table.AbstractTableModel;

public class PetModel extends AbstractTableModel{

	//아래의 모든 메서드는 개발자를 위한게 아니라!!
	//JTable이 호출하는 메서드이다!!
	String[] column={"이름","종류","성별"};
	String[][] data={
			{"이상신","도베르만","암컷"},
			{"이상신2","불독","수컷"},
			{"이상신3","치와와","암컷"},
	};
	@Override
	public String getColumnName(int col) {

		return column[col];
	}
	public int getRowCount() {
		return data.length;
	}

	
	public int getColumnCount() {
		return column.length;
	}

	
	public Object getValueAt(int row, int col) {
		return data[row][col];
	}

}
