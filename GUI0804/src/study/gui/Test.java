package study.gui;

import java.awt.Frame;

public class Test {
	private String name;
	private int  Price;
	

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public static void main(String[] args) {
		
		Frame f=new Frame("³ª Á¦¸ñ");
		f.setVisible(true);
		f.setSize(300, 400);
		
	}

}
