/*
 * 	자바 기반의 어플리케이션의 이벤트 구현순서!
	1단계 - 알맞는 리스너를 선택하기!
	2단계 - 리스너의 메서드 재정의하기!(불완전한 메서드 완성)
	3단계 - 이벤트 소스(이벤트 일으킨 컴포넌트)와 
				리스너와의 연결!
	
 * */
package gui;

import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class KeyTest extends JFrame implements KeyListener{
	JTextField tf;
	JButton bt;
	
	
	public KeyTest(){
		tf=new JTextField(10);
		bt=new JButton("클릭");
		
		this.setLayout(new FlowLayout());
		this.add(tf);
		this.add(bt);
		
		this.setSize(300,400);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		//현재 클래스는 프레임이자, 곧 key리스너이므로..
		tf.addKeyListener(this);
		
	}
	

	@Override
	public void keyTyped(KeyEvent e) {
		
	}


	@Override
	public void keyPressed(KeyEvent e) {
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("눌렀다 떼었어?");
		
	}
	public static void main(String[] args) {
		new KeyTest();
		
	}
}
