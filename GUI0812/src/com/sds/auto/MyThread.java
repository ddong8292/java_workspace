/*
 * 하나의 프로세스내에서 독립적으로 실행되는 세부실행단위
 * 쓰레드라 하며 Thread 클래스로 지원한다 
 * 주의) 쓰레드는 자바의 개념이 아니다!! 현존 하는 대부분의
 *         응용프로그램은 쓰레드가 지원된다..
 *         c, c#, javascript(=setTimeout()  으로 비슷하게 구현)
 * */
package com.sds.auto;

public class MyThread extends Thread{
	int count;
	/*개발자는 독립적으로 수행하고 싶은 코드가 있다면
	 run() 메서드를 재정의하면 된다!!
	*/
	public void run() {
		while(true){
			try {
				Thread.sleep(1000); //1초동안 non-runnable 상태로
				//있어라!! 1초 지나면 다시 runnable 로 복귀
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			count++;
			System.out.println(count);
		}
	}
}











