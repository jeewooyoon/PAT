package 시험공부;
import java.util.*;
public class J05 {
	int CalcParking(int start_h, int start_m, int end_h, int end_m) {
		int start=0;
		int end=0;
		start = start_h*60+start_m;
		end = end_h*60+end_m;
		if((end-start)%10!=0) {
			return ((end-start)/10+1)*500;
		}else {
			return (end-start)/10*500;
		}
		
	}
	public static void main(String[] args) {
		J05 j = new J05();
		Scanner scan = new Scanner(System.in);
		String ans="y";
		int i=0;
		int total=0;
		int start_h; int start_m; int end_h; int end_m;
		while(true) {
			i++;
			System.out.print(i+"번 차량 주차 시작시간");
			start_h=scan.nextInt();
			start_m=scan.nextInt();
			System.out.print(i+"번 차량 주차 종료시간");
			end_h=scan.nextInt();
			end_m=scan.nextInt();
			System.out.println("주차요금 : "+j.CalcParking(start_h, start_m, end_h, end_m));
			total+=j.CalcParking(start_h, start_m, end_h, end_m);
			
			System.out.print("더 입력하시겠습니까?(y/n)");
			ans=scan.next();
			if(ans.equals("n")) {
				break;
			}
			
		}
		System.out.print("주차차량 "+i+"대의 총 주차 요금은 "+total+"원 입니다.");
	
	}

}
