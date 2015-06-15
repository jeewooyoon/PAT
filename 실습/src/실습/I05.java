package 실습;
import java.util.Scanner;
public class I05 {
	int MaxOfTen() {
		Scanner scan = new Scanner(System.in);
		int i;
		int max=0;
		int num;
		for(i=1;i<=10;i++) {
			System.out.print(i+"번째 수를 입력하시오.");
			num=scan.nextInt();
			if(num>max) {
				max=num;
			}
		}
		return max;
	}
	public static void main(String[] args) {
		I05 I = new I05();
		System.out.println("10개의 숫자 중 최댓값을 구합니다.");
		System.out.println("최댓값은 "+I.MaxOfTen()+"입니다.");
	}

}
