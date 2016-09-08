package com.iot.main;

class MainTest{
	public void test(String[] k){
		for(int i=0;i<k.length;i++){
			System.out.println(k[i]);
		}
		k[0]="¼ö¹Ú";
	}
	public static void main(String[] args){
		MainTest mt = new MainTest();
		String[] arr = new String[3];
		arr[0]="»ç°ú";
		arr[1]="µþ±â";
		arr[2]="¿À·»Áö";

		mt.test(arr);
		System.out.println(arr[0]);
	}
}
