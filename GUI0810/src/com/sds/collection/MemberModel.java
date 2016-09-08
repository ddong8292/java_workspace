/*
  JTable  껍데기에 불과하기 때문에 실제 데이터를 연동한
  객체인  TableModel 을 정의하여,  회원관리 프로그램에
  출력할  JTable 에 보여질 데이터를 처리해보자!!
*/
package com.sds.collection;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class MemberModel extends AbstractTableModel{
	String[] column={"ID","Password","Name"};
	//String[][] data=new String[0][0];
	
	//배열은 그 크기가 고정되어 있으므로, 컬렉션 프레임웍
	//을 이용하여 기능을 개선하자!!
	ArrayList<String[]> list = new ArrayList<String[]>();
	
	public int getColumnCount(){
		return column.length;
	}
	public String getColumnName(int col) {
		return column[col];
	}
	public int getRowCount() {
		return list.size();
	}
	public Object getValueAt(int row, int col) {
		String[] record=list.get(row);
		return record[col];
	}	
	public boolean isCellEditable(int row, int col) {
		//System.out.println(row+","+col+"편집할까요?");
		if(col==1){
			return false;
		}else{
			return true;
		}
	}
	@Override
	public void setValueAt(Object v, int row, int col) {
		System.out.println(v+" 값을 "+row+","+col+" 에 넣을래!!");
		String[] record=list.get(row);
		record[col]=(String)v;		
	}
}









