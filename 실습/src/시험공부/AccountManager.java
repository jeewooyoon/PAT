package 시험공부;

import java.util.*;

class BankAccount {
	int no;
	String name;
	int money;
	int grade;

	BankAccount(int no, String name, int money, int grade) {
		this.no=no;
		this.name=name;
		this.money=money;
		this.grade=grade;
	}
	
	public void save(int money) {
		this.money+=money;
	}
	public void draw(int money) {
		if((this.money>=money)) {
			this.money-=money;
		}else{
			if(this.grade==1) {
				this.money-=money;
			}else {
				System.out.println("금액이 모자랍니다.");
			}
		}
	}
	public void print() {
		System.out.println(no+"\t"+name+"\t"+money+"\t"+grade);
	}
	public int getAmount() {
		return this.money;
	}
	
}
public class AccountManager {
	Scanner scan = new Scanner(System.in);
	BankAccount [] a = new BankAccount[20];
	int cnt=0;
	
	public void start() {
		while(true) {
			System.out.println("1)개설 2)입금 3)출금 4)송금 5)이자지급 6)통장내역출력 7)특정통장출력 8)종료");
			int select = scan.nextInt();
			if(select==1) {
				System.out.println("통장개설!");
				addAccount();
			}else if(select==2) {
				System.out.println("입금할 통장번호 입력!");
				int num = scan.nextInt();
				System.out.println("입금할 금액입력!");
				int money = scan.nextInt();
				a[num-1].save(money);
				
			}else if(select==3) {
				System.out.println("출금할 통장번호 입력!");
				int num = scan.nextInt();
				System.out.println("출금할 금액입력!");
				int money = scan.nextInt();
				a[num-1].draw(money);
			}else if(select==4){
				transferMoney();
			}else if(select==5) {
				putInterest();
			}else if(select==6) {
				printAccount();
			}else if(select==7) {
				viewAccount();
			}else if(select==8){
				break;
			}
		}
	}
	public void addAccount() {
		System.out.print("이름 입력");
		String name = scan.next();
		System.out.print("잔액 입력");
		int money = scan.nextInt();
		System.out.print("신용등급 입력");
		int grade = scan.nextInt();
		a[cnt]=new BankAccount(cnt+1, name, money, grade);
		cnt++;
	}
	public void printAccount() {
		System.out.println("통장번호\t이  름\t통장잔액\t신용등급");
		
		for(int i=0;i<cnt;i++) {
			a[i].print();
		}
	}
	public void viewAccount() {
		System.out.println("출력할 통장번호");
		int num=scan.nextInt();
		System.out.println("통장번호\t이  름\t통장잔액\t신용등급");
		a[num-1].print();
	
	}
	public void transferMoney() {
		System.out.println("송금할 통장번호 입력!");
		int from = scan.nextInt();
		System.out.println("송금받을 통장번호 입력!");
		int to = scan.nextInt();
		System.out.println("송금할 금액입력!");
		int money = scan.nextInt();
		a[from-1].draw(money);
		if(a[from-1].grade!=1) {
			;
		}else {
			a[to-1].save(money);
	
		}
	}
	public void putInterest() {
		for(int num=1; num<=cnt;num++) {
			if(a[num-1].money>0) {
				if(a[num-1].grade==1) {
					a[num-1].save((a[num-1].money*3/100));
				}else if(a[num-1].grade==2) {
					a[num-1].save((a[num-1].money*2/100));
				}else {
					a[num-1].save((a[num-1].money*1/100));
				}
			}
		}
	}
	void saveMoney(int no) {
		int money=scan.nextInt();
		a[no].save(money);
	}
	void drawMoney(int no) {
		int money=scan.nextInt();
		a[no].draw(money);
	}
	
	
	public static void main(String[] args) {
		AccountManager m = new AccountManager();
		m.start();
	}

}
