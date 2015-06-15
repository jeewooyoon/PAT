package 실습;
import java.util.*;
public class L01 {
	int num;
	String menu;
	String from;
	int price;
	L01(int num, String menu, String from, int price) {
		this.num=num;
		this.menu=menu;
		this.from=from;
		this.price=price;
	}
	
	void output() {
		System.out.println(this.num+"\t"+this.menu+"\t"+this.from+"\t"+this.price);
	}
	public static void main(String[] args) {
		ArrayList<L01> al = new ArrayList<L01>();
		int cnt=0;
		
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			System.out.println("1 추가 2 수정 3 삭제 4 리스트 5 총개수 6 종료 ");
			int res = scan.nextInt();
			if(res==1) {
				String name = scan.next();
				String from = scan.next();
				int price = scan.nextInt();
				
				al.add(new L01(cnt+1,name,from,price));
				cnt++;
			}else if(res==2) {
				for(int i=0;i<al.size();i++) {
					al.get(i).output();
				}
				System.out.print("수정할 번호를 입력하세요.");
				int replace = scan.nextInt();
				al.remove(replace-1);
				
				String name = scan.next();
				String from = scan.next();
				int price = scan.nextInt();
				al.add(replace,new L01(replace,name,from,price));
				System.out.println("수정되었습니다.");
			}else if(res==3) {
				for(int i=0;i<al.size();i++) {
					al.get(i).output();
				}
				System.out.println("삭제할 번호를 입력하세요.");
				int remove = scan.nextInt();
				al.remove(remove-1);
			}else if(res==4) {
				for(int i=0;i<al.size();i++) {
					al.get(i).output();
				}
			}else if(res==5) {
				System.out.println(cnt+"개의 메뉴가 등록되어 있습니다.");
			}else {
				System.out.println("종료되었습니다.");
				break;
			}
		}
	}

}
