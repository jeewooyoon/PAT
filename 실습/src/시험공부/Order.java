package 시험공부;

public class Order {

	int num;
	int menuCNT[];
	String name;
	int price;
	

	Order(int num, int[] menuCNT, String name, int price) {
		this.num=num;
	    this.menuCNT=menuCNT;
		this.name=name;
		this.price=price;
	}
	public int getMenuCNT(int s) {
		return menuCNT[s];
	}
	public String toString() {
		return this.num+"\t"+this.name+"\t"+this.price;
	}
	

}
