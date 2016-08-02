package com.iot.main;
class Test{
	public static void main(String[] args){
		String str="korea java";

		char c=str.charAt(3);
		System.out.println(c);
		
		int a=str.indexOf("a");
		System.out.println(a);
		
		int b=str.lastIndexOf("a");
		System.out.println(b);
		
		int d=str.length();
		
		String f=str.replace("korea", "ÄÚ¸®¾Æ");
		System.out.println(f);
		
		String e=str.substring(2,8);
		System.out.println(e);
		
		String g=str.toUpperCase();
		System.out.println(g);
		
		String s="photo.jpg";

		String[] arr=s.split("\\.");
		System.out.println(arr[0]);
		System.out.println(arr[1]);

	}
}
