package 실습;
import java.util.*;
class MenuPan {
	int num;
	String name;
	String from;
	int price;
	
	void input() {
		Scanner scan = new Scanner(System.in);
		num=scan.nextInt();
		name=scan.next();
		from=scan.next();
		price=scan.nextInt();
	}
	
	void print() {
		System.out.println("메뉴번호\t메뉴이름\t원산지\t1인분가격\t");
		System.out.println(num+"\t"+name+"\t"+from+"\t"+price);
	}
}

public class K02 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("등록하실 메뉴의 개수를 입력하세요");
		int m = scan.nextInt();
		MenuPan [] k = new MenuPan[m];
		for(int i=0;i<k.length;i++) {
			k[i]=new MenuPan();
		}
		for(int i=0;i<m;i++) {
			System.out.print(i+1+"번 메뉴의 번호, 이름, 원산지, 가격입력.");
			k[i].input();
		}
		for(int i=0;i<m;i++) {
			k[i].print();
		}

	}

}
