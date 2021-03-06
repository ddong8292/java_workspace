/*
 * 배열은 데이터를 메모리에 순서있게 올려놓는 용도로는
 * 아주 훌륭하다..하지만, 대부분의 응용프로그램에서 배열은
 * 생성시 반드시 그 크기를 명시해야 한다!!
 * 때로는 이 규칙은 유연하지 못하다..
 * 
 * 자바언어에서는 객체를 모아서 처리할때 보다 효율적으로
 * 처리하기 위한 패키지가 지원되며 이 패키지를 가리켜 
 * 컬렉션 프레임웍이라 한다!! 
 * 
 [ 컬렉션 프레임웍의 유형 ] 
 1.순서있는 모습: List
    List 의 특징 - 배열과 거의 같다...
    차이점?? 배열은 기본자료형까지도 지원하지만, List를 포함
    한 컬렉션 프레임웍의 대상은 객체만으로 한정된다..
    배열은 생성시 그 크기를 명시해야 하지만(정적), 컬렉션
    프레임웍은 동적으로 늘어난다. 또한 생성시 그 크기를 명시
    하지 않아도 된다..
      
 2.순서없는 모습 : Set
 
 3.key-value의 쌍으로 이루어진 모습 : Map
 
 컬렉션 프레임웍은 java.util 패키지에서 지원!!
*/
package com.sds.collection;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CollectionTest extends JFrame {
	ArrayList<JButton> list;
	JPanel p_north, p_center;
	JButton bt_create, bt_color;

	public CollectionTest() {
		list = new ArrayList<JButton>();//리스트 생성!!
		p_north = new JPanel();
		p_center = new JPanel();
		p_center.setBackground(Color.GREEN);
		bt_create = new JButton("생성");
		bt_color = new JButton("색상");
		
		p_north.add(bt_create);
		p_north.add(bt_color);
		
		add(p_north, BorderLayout.NORTH);
		add(p_center);
		
		//생성
		bt_create.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//버튼을 생성!!
				JButton bt = new JButton("나버튼");
				p_center.add(bt);
				p_center.updateUI();
				
				//생성된 버튼을 List에 담자!!
				list.add(bt);
				
				System.out.println("현재까지 리스트의 크기는 "+list.size());
			}
		});
		
		//색상변경
		bt_color.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i=0;i<list.size();i++){
					JButton bt=list.get(i);
					bt.setBackground(Color.YELLOW);
				}
			}
		});
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setSize(500, 600);
	}

	public static void main(String[] args) {
		new CollectionTest();
	}

}
