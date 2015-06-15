package 시험공부;

import java.util.ArrayList;
import java.util.Scanner;


public class OrderManager {
	Scanner scan = new Scanner(System.in);
	Order orders[];
	int cnt=0;
	int menuCNT[];
	int totalCNT[]={0,0,0,0};
	int totalprice=0;
	String[] menuname = {"후라이드","양념","강정","양파"};
	ArrayList<Order> al= new ArrayList<Order>();
	public OrderManager(Order orders[], int totalCNT[], int totalprice, String[] menuname) {
		this.orders=orders;
		this.totalCNT=totalCNT;
		this.totalprice=totalprice;
		this.menuname=menuname;
	}
	public OrderManager() {
		
	}
	public void findOrder(int n) {
		if(n<=4&&n>=1) {
			System.out.println("주문번호\t주문자\t금액");
			
			if(n==1) {
				for(int i=0;i<al.size();i++) {
					if(al.get(i).getMenuCNT(0)!=0) {
						System.out.println(al.get(i).toString());
					}
				}
			}else if(n==2) {
				for(int i=0;i<al.size();i++) {
					if(al.get(i).menuCNT[1]!=0) {
						System.out.println(al.get(i).toString());
					}
				}
			}else if(n==3) {
				for(int i=0;i<al.size();i++) {
					if(al.get(i).menuCNT[2]!=0) {
						System.out.println(al.get(i).toString());
					}
				}
			}else if(n==4){
				for(int i=0;i<al.size();i++) {
					if(al.get(i).menuCNT[3]!=0) {
						System.out.println(al.get(i).toString());
					}
				}
			}
		}else if(n>=100) {
			System.out.println("n이 100이상이므로 특정금액 이상의 주문서만 출력합니다.");
			System.out.println("특정금액입력");
			int partic =scan.nextInt();
			System.out.println("주문번호\t주문자\t금액");
			for(int i=0;i<al.size();i++) {
				if(al.get(i).price>=partic) {
					System.out.println(al.get(i).toString());
				}
			}
		}
			
		
	}
	public void findOrder(String n) {
		System.out.println("주문번호\t주문자\t금액");
		for(int i=0;i<al.size();i++) {
			if(al.get(i).name.equals(n)) {
				System.out.println(al.get(i).toString());
			}
		}
	}
	public void addOrder() {
		cnt++;
		boolean h = false;
		int menuCNT[]= new int [4];
		System.out.println("후라이드(1000) 개수");
		menuCNT[0]=scan.nextInt();
		totalCNT[0]+=menuCNT[0];
		System.out.println("양념(2000) 개수");
		menuCNT[1]=scan.nextInt();
		totalCNT[1]+=menuCNT[1];
		System.out.println("강정(3000) 개수");
		menuCNT[2]=scan.nextInt();
		totalCNT[2]+=menuCNT[2];
		System.out.println("양파(4000) 개수");
		menuCNT[3]=scan.nextInt();
		totalCNT[3]+=menuCNT[3];
		System.out.println("고객이름");
		String name = scan.next();
		int price = (menuCNT[0]*1000)+(menuCNT[1]*2000)+(menuCNT[2]*3000)+(menuCNT[3]*4000);
		totalprice+=price;
		
		for(int i=0;i<al.size();i++) {
			if(al.get(i).name.equals(name)) {
				al.get(i).menuCNT[0]+=menuCNT[0];
				al.get(i).menuCNT[1]+=menuCNT[1];
				al.get(i).menuCNT[2]+=menuCNT[2];
				al.get(i).menuCNT[3]+=menuCNT[3];
				al.get(i).price+=price;
				h=true;
				cnt--;
			}
		}
		if(h==false) {
			al.add(new Order(cnt, menuCNT, name, price));	
		}
	}
	public void cancelOrder() {
		
		System.out.println("취소할 주문번호");
		int n = scan.nextInt();
		
		for(int i=0;i<al.size();i++) {
			if(al.get(i).num==n) {
				totalCNT[0]-=al.get(i).menuCNT[0];
				totalCNT[1]-=al.get(i).menuCNT[1];
				totalCNT[2]-=al.get(i).menuCNT[2];
				totalCNT[3]-=al.get(i).menuCNT[3];
				totalprice-=al.get(i).price;
				al.remove(i);
				
			}
		}
		

	}
	public void printOrder() {
		System.out.println("주문번호\t주문자\t금액");
		for(int i=0;i<al.size();i++) {
			System.out.println(al.get(i).toString());
		}
	}
	public void viewStatus() {
		System.out.println("주문서 개수\t|\t메뉴별 주문갯수\t\t|\t판매금액 총액");
		System.out.println(al.size()+"\t\t|후라이드 :"+totalCNT[0]+" 양념 :"+totalCNT[1]+" 강정 :"+totalCNT[2]+" 양파 :"+totalCNT[3]+"|\t"+totalprice);
	}
	public void bestCustomer() {
		int a[] = new int [al.size()];
		for(int k =0;k<al.size();k++) {
			a[k]=0;
		}
		for(int i=0;i<al.size();i++) {
			for(int j=0;j<al.size();j++) {
				if(al.get(i).name.equals(al.get(j).name)) {
					a[i]+=al.get(i).price;
				}
			}
		}
		int max=0;
		int index = 0;
		for(int i=0;i<al.size();i++) {
			if(a[i]>max) {
				max=a[i];
				index=i;
			}
		}
		System.out.println(al.get(index).name);
	}
	public void start() {
		while(true) {
			System.out.println("1)주문추가, 2)주문취소, 3)주문서출력, 4)주문서찾기, 5)판매현황보기, 6)베스트고객, 7)종료");
			int select = scan.nextInt();
			if(select==1) {
				addOrder();
			}else if(select==2) {
				cancelOrder();
			}else if(select==3) {
				printOrder();
			}else if(select==4) {
				System.out.print("찾고싶은 메뉴번호 혹은 찾고싶은 고객이름을 입력.");
				String sel = scan.next();
				int num=0;
				try {
					num =Integer.parseInt(sel);
					findOrder(num);
				}catch (Exception e) {
					findOrder(sel);
				}
				//if(sel==1) {
				//	System.out.println("특정 메뉴를 고르시오 1)후라이드 2)양념 3) 강정 4)양파");
				//	int n = scan.nextInt();
				//	findOrder(n);
				//}else if(sel==2) {
				//	System.out.println("특정 주문자 이름 입력.");
				//	String n = scan.next();
				//	findOrder(n);
				//}
			}else if(select==5) {
				viewStatus();
			}else if(select==6) {
				bestCustomer();
			}else {
				break;
			}
		}
	}
	public static void main(String[] args) {
		
		
		OrderManager m = new OrderManager();
		
		m.start();
	}

}
