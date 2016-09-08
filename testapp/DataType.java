/*
변수에 데이터를 담아서 선언할때는 반드시 변수가 담게될
데이터의 용량을 표시해야 하는데, 이 용량표시를 자료형이라
한다.
불편하기는 하지만, 개발자가 메모리 용량을 결정지을 수 있다!!

1.문자 : char (2byte)=16bit   2의 16승가지
2.숫자 : byte(1byte)=8bit 
			<short(2byte)16bit
			<int(4byte)  32bit
			< long(8byte) 64bit
3.논리값 : boolean (1byte)
mm (최소)  -----   cm 
g    (최소) -------  kg

bit   (최소) ------- byte
*/
class  DataType{
	public static void main(String[] args){
		//문자 자료형 !! (케릭터형)
		char c='대'; //문자열이 아닌 하나의 문자는 홑따옴표

		//2byte 짜리 데이터가 총 4개 확보 = 8byte
		char[] arr=new char[4];
		arr[0]='대';
		arr[1]='한';
		arr[2]='민';
		arr[3]='국';

		char[] arr2={'아','메','리','카'};

		for(int i=0;i<arr.length;i++){
			//System.out.print("c의 값은 "+arr[i]);
			//System.out.print("c의 값은 "+arr2[i]);
		}
		
		byte a=77;
		long k=3434;

		//a+k;
		boolean m=true;

		//
		byte t=128;
	}
}
