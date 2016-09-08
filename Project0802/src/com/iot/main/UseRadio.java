class UseRadio{

	public void getInfo(TV t){
		System.out.println(t.price);
		t.price=20;
	}
	public void showPrice(int k, boolean b){
	}
	public static void main(String[] args){
		UseRadio ur = new UseRadio();
		ur.showPrice(3,true);

		TV v = new TV();
		v.price=500;

		ur.getInfo(v);
		System.out.println(v.price);
	}
}
