/*
 *java.awt는 os플랫폼마다 (Linux, Mac, Window..)디자인이 틀리다. 따라서 이를 보완한
 *API인 Swing을 사용해 본다.
 *Swing의 특징 : javax.swing 패키지에서 지원.
 *					 컴포넌트가 awt 거의 동일 Button-->JButton
 *			주의 : awt를 욕해선 안된다.
 *			 왜? : 디자인적인것 이외에는 아직도 사용한다.
 *			결론 : GUI프로그램시 개발시 Swing+awt 조합!
 *			
 *	자바의 GUI컴포넌트의 종류는 크게 2가지가 있다.
 *	1.Container(남을 포함하는 컴포넌트) - 
 *		JFrame(BorderLayout)
 *		JPanel(FlowLayout)
 *			-컨테이너이다. 하지만 단독으로 존재할 수 없고, 반드시 프레임안에 소속되어 있다. 
 *			 특징 : 눈에 보이지 않는다(div 흡사)
 *			 주용도 : Frame 내에서 별도의 개별적 레이아웃을 적용시키고 싶을때 사용		
 *		Applet(FlowLayout)
 *	2.Visual Component(포함당하는 컴포넌트) - 
 *		JButton
 *		JCheckbox
 *		JTextArea 등등
	
 * */
package gui;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Chatwin extends JFrame{
	JTextArea tx;
	JTextField tf;
	JButton bt;
	JPanel p;
	public Chatwin(){
		super("asd");
		tx=new JTextArea();
		tf=new JTextField(15);
		bt=new JButton("전송");
		p=new JPanel();//판자 생성!!
		this.add(p, BorderLayout.SOUTH);
		this.add(tx, BorderLayout.CENTER);
		p.add(tf);
		p.add(bt);
		
		//윈도우 창을 닫으면, 프로세스도 죽이기!
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(300, 400);
		this.setVisible(true);
	}
		public static void main(String[] args) {
			new Chatwin();
			
			
	}

}
