/*
 * JTable�� ������ ������ �� �ְ߰��� �����͸� ó���ϴ� TableModel
 * */
package com.sds.collection;

import javax.swing.table.AbstractTableModel;

public class PetModel extends AbstractTableModel{

	//�Ʒ��� ��� �޼���� �����ڸ� ���Ѱ� �ƴ϶�!!
	//JTable�� ȣ���ϴ� �޼����̴�!!
	String[] column={"�̸�","����","����"};
	String[][] data={
			{"�̻��","��������","����"},
			{"�̻��2","�ҵ�","����"},
			{"�̻��3","ġ�Ϳ�","����"},
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
