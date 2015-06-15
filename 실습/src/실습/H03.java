package 실습;
import java.util.Scanner;
import java.util.Random;
public class H03 {

	public static void main(String[] args) {
		int lotto_com[] = new int[6];
		int lotto_user[] = new int[6];
		int i;
		int j;
		
		
	
		int cnt=0;
		int match_cnt=0;
		Scanner scan = new Scanner(System.in);
		Random rand = new Random();
		while(true) {
			lotto_com[cnt]=rand.nextInt(45)+1;
			for(i=0;i<6;i++) {
				if((lotto_com[cnt]==lotto_com[i])&&cnt!=i) {
					match_cnt++;
				}
			}
			if(match_cnt==0) {
				cnt++;
			}
			if(cnt==6) {
				break; 
			}
			match_cnt=0;
			
			
		}
		cnt=0;
		match_cnt=0;
		while(true) {
			System.out.println("원하는"+(cnt+1)+"번 숫자를 입력.");
			lotto_user[cnt]=scan.nextInt();
	
			for(i=0;i<6;i++) {
				if((lotto_user[cnt]==lotto_user[i])&&cnt!=i) {
					match_cnt++;
				}
			}
			if(lotto_user[cnt]<1||lotto_user[cnt]>45||match_cnt!=0) {
				System.out.println("잘못.");
				match_cnt=0;
			}else {
				cnt++;
			}
			if(cnt==6) {
				break;
			}
		}
		match_cnt=0;
		for(i=0;i<6;i++) {
			for(j=0;j<6;j++) {
				if(lotto_user[i]==lotto_com[j]) {
					match_cnt++;
				}
			}
		}
		System.out.println("이번주 번호는"+lotto_com[0]+" "+lotto_com[1]+" "+lotto_com[2]+" "+lotto_com[3]+" "+lotto_com[4]+" "+lotto_com[5]+" ");
		
		System.out.println("일치하는 로또의 개수"+match_cnt+"개 입니다.");
	}
}


