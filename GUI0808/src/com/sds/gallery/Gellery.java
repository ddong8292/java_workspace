package com.sds.gallery;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Gellery extends JFrame implements ActionListener{
	JPanel p;
	JButton bt1;
	JButton bt2;
	JTextField txt;
	XCanvas can;
	
	public Gellery(){
		can= new XCanvas();
		p=new JPanel();		
		bt1=new JButton("��");
		bt2=new JButton("��");
		txt=new JTextField(30);
		
		p.add(bt1);
		p.add(txt);
		p.add(bt2);
		
		add(p,BorderLayout.SOUTH);
		add(can);

		//�����Ϳ� ��ư ����
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		
		setSize(700, 800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	//���� �̹��� �����ֱ�
	public void prev(){
		//JOptionPane.showMessageDialog(this, "���� �̹���");
		
		
		if(can.count<can.path.length-1){
			can.count--;
			can.repaint();
			JOptionPane.showMessageDialog(this, "���������� �����ϴ�");		
		}
	
	}
	//���� �̹��� �����ֱ�
	public void next(){
		//JOptionPane.showMessageDialog(this, "���� �̹���");
		//XCanvas�� ������ count ������ 1����!
		
		can.count++;
		//�ٽ� �׷����� ��û! repaint()->update()ȭ������-->paint()�ٽ� �׸�
		can.repaint();
		if(can.count>can.path.length-1){
			JOptionPane.showMessageDialog(this, "���������� �����ϴ�");
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj=e.getSource();//�̺�Ʈ ����Ų ������Ʈ ��ȯ!!
		if(obj.equals(bt1)){//���� ��ư�̶��..
			prev();
		}else if(obj==bt2){//���� ��ư�̶��..
			next();
		}
	}

	public static void main(String[] args) {
		new Gellery();
		
	}
}
