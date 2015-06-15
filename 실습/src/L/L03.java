package L;

import java.util.*;
import java.text.*;

public class L03 {
	
	String today;
	int customer;
	static int cnt=0;
	int ste;
	int spa;
	int pas;
	int num;
	String time;
	String membership;
	int total;
	L03(int num,int customer,int ste, int spa, int pas,String membership,int total, String today) {
		this.customer=customer;
		this.ste=ste;
		this.spa=spa;
		this.pas=pas;
		this.membership=membership;
		this.total=total;
		this.num=num;
		this.today=today;
	}
	
	void printList() {
		System.out.println(num+1+"\t"+customer+"\t"+ste+"\t"+spa+"\t"+pas+"\t"+membership+"\t"+today);
	}
	void printCheck() {
		System.out.println(num+1+"\t"+customer+"\t"+ste+"\t"+spa+"\t"+pas+"\t"+membership+"\t"+total+"\t"+today);
	}
	public static void main(String[] args) {
		SimpleDateFormat f = new SimpleDateFormat("YYYY년 MM월 dd일 kk:mm", Locale.KOREA); 
		
		ArrayList<L03> al = new ArrayList<L03>();
		Scanner scan = new Scanner(System.in);
		System.out.println("1)주문 2)결제 3)리스트 4)종료");
		int res = scan.nextInt();
		while(true) {
			String today = f.format(new Date());
			if(res==1) {
				System.out.print("손님 수를 입력하세요.");
				int customer=scan.nextInt();
				System.out.println("스테이크,스파케티,파스타의 개수를 입력.");
				int ste = scan.nextInt();
				int spa = scan.nextInt();
				int pas = scan.nextInt();
				System.out.println("멤버쉽카드가 있습니까?(Y/N)");
				String membership = scan.next();
				int total = ste*25000 + spa*15000 + pas*17000;
				if(membership.equals("Y")) {
					total=total*9/10;
				}
				if(total>=100000) {
					total=total+total*10/100;
				}else {
					total=total+total*7/100;
				}
				total=total+total*10/100;
				System.out.println("들어오신 시간은 "+today+"입니다.");
				System.out.println("총 금액은 "+total+"원 입니다.");
				al.add(new L03(cnt,customer,ste,spa,pas,membership,total,today));
				cnt++;
			}else if(res==2) {
				System.out.println("-----------------------------------------------------");
				System.out.println("번호\t손님수\t스테이크\t스파게티\t파스타\t멤버쉽\t결제금액\t입장시간");
				System.out.println("-----------------------------------------------------");
				for(int i=0;i<al.size();i++) {
					al.get(i).printCheck();
				}
				System.out.print("결제하실 번호를 입력.");
				int check = scan.nextInt();
				al.remove(check-1);
				System.out.println("결제완료되었습니다.");
			}else if(res==3) {
				System.out.println("-----------------------------------------------------");
				System.out.println("번호\t손님수\t스테이크\t스파게티\t파스타\t멤버쉽\t입장시간");
				System.out.println("-----------------------------------------------------");
				for(int i=0;i<al.size();i++) {
					al.get(i).printList();
				}
			}else {
				System.out.println("종료");
				break;
			}
			System.out.println("1)주문 2)결제 3)리스트 4)종료");
			res = scan.nextInt();
		}
	}

}




