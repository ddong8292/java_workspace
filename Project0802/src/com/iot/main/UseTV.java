package com.iot.main;
class UseTV{

	public void showPrice(){
		MyTV tv=new MyTV();
		tv.printPrice();
	}
	public static void main(String[] args){
		UseTV ut=new UseTV();
		ut.showPrice();
	}
}
