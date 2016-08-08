package com.sds.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class MyListener implements ActionListener {
	EventTest2 et;//null
	
	//멤버변수인 et에 이미 떠있는 윈도우인 EventTest2에 레퍼런스 주입시키자!
	public void setEt(EventTest2 et){
		this.et=et;
		System.out.println("넘겨받은 주소값은"+et);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//System.out.println("클릭");
		//JTextfild에 문자열 출력!
		JTextField tf=et.tf;
		tf.setText("눌렀어?");
	}

}
