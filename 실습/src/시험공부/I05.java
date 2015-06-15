package 시험공부;
import java.util.*;
public class I05 {
	Scanner scan = new Scanner(System.in);
	int MaxOfTen() {
		int max=0;
		System.out.println("10개의 숫자 중 최댓값을 구합니다.");
		for(int i=0;i<10;i++) {
			System.out.print(i+1+"번 수를 입력하시오.");
			int num = scan.nextInt();
			if(num>max) {
				max=num;
			}
		}
		return max;
	}
	public static void main(String[] args) {
		I05 i = new I05();
		System.out.print("최댓값은"+i.MaxOfTen()+"입니다.");
	}

}
