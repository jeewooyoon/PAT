package 실습;
import java.util.Scanner;
public class D01 {

	public static void main(String[] args) {
		int number;
		int totalsum=0;
		int i;
		Scanner scan = new Scanner(System.in);
		System.out.println("숫자를 입력하세요.");
		number=scan.nextInt();
		for(i=1;i<=number;i++) {
			totalsum+=i;
		}
		System.out.println("1부터 입력한 숫자까지의 모든 정수들의 합은 "+totalsum+"입니다.");
		
	}

}
