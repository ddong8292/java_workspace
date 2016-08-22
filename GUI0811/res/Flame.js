var Flame=function(a,w,h,posX,posY){
/*----------------------------------------------------
	불꽃을 정의한다
	a:어떤 div에 붙을지
	w:가로 크기
	h:높이
	posX: 초기 x좌표 위치
	posY: 초기 y좌표 위치
	----------------------------------------------------*/

	/*가로, 세로, 크기, 위치*/
	this.width=w;
	this.height=h;
	this.x=posX;
	this.y=posY;
	this.img;
	this.arr=new Array();
	this.area=a;
	this.count=0;//이미지를 교체하면서 보여줄 index

	//이 객체가 태어날때(메모리에 올라올때) 하고싶은 초기작업
	//에 사용될 메서드 정의
	
	this.init=function(){
		this.img=document.createElement("img");
		
		this.arr[0]="../images/flame/flame1.png";
		this.arr[1]="../images/flame/flame2.png";
		this.arr[2]="../images/flame/flame3.png";
		this.arr[3]="../images/flame/flame4.png";
		
		this.img.src=this.arr[this.count];
		
		//이미지의 가로, 세로 크기
		this.img.style.width=this.width+"px";
		this.img.style.height=this.height+"px";
		

		//호출자가 결정하는 영역에 붙일거임
		this.area.appendChild(this.img);
		this.move();
	}

	//동작방식 표현
	this.move=function(){
		var me=this;
		//이미지를 계속 교체해서 보여줄거임
		//src값을 변경.
		this.count++;
		if(this.count>=this.arr.length){
			this.count=0;
			}
		this.img.src=this.arr[this.count];
		
		setTimeout(function(){me.move();},70);
	}

}